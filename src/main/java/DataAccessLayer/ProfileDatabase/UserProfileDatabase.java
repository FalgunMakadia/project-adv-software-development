package DataAccessLayer.ProfileDatabase;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.UserFactory;
import DataAccessLayer.DatabaseConnection.DatabaseConnection;
import DataAccessLayer.DatabaseConnection.IDatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.*;

public class UserProfileDatabase implements IUserProfileDatabase {
    private static final String USERNAME_COLUMN_NAME = "userName";
    private static final String USER_ROLE_COLUMN_NAME  = "userRole";
    private static final String ACCOUNT_NUMBER_COLUMN_NAME  = "accountNumber";
    private static final String ACTIVE_STATUS_COLUMN_NAME  = "ActiveStatus";

    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private IDatabaseConnection databaseConnection;
    private ILoggedInUserContext loggedInUserContext;

    private UserFactory userFactory;
    public UserProfileDatabase() {
        databaseConnection = DatabaseConnection.instance();
        userFactory =  new UserFactory();

        loggedInUserContext = userFactory.getLoggedInUserContext();
    }

    @Override
    public void validateUser(String username, int password) {
        connection = databaseConnection.openConnection();
        ResultSet resultSet = null;
        String loginQuery = "SELECT * FROM login WHERE userName = ? AND userPassword = ?";
        try {
            preparedStatement = connection.prepareStatement(loginQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, password);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                loggedInUserContext.setUserName(resultSet.getString(USERNAME_COLUMN_NAME));
                loggedInUserContext.setUserRole(resultSet.getString(USER_ROLE_COLUMN_NAME));
                loggedInUserContext.setAccountNumber(resultSet.getString(ACCOUNT_NUMBER_COLUMN_NAME));
                loggedInUserContext.setActiveStatus(resultSet.getBoolean(ACTIVE_STATUS_COLUMN_NAME));
                loggedInUserContext.setLoginStatus(true);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
    }

    @Override
    public int addNewUser(String userName, String defaultPassword, String userRole) {
        connection = databaseConnection.openConnection();
        int affectedRow = 0;
        String query = "INSERT INTO login VALUES (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, defaultPassword);
            preparedStatement.setString(3, null);
            preparedStatement.setString(4, userRole);
            preparedStatement.setBoolean(5, false);
            affectedRow = preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return affectedRow;
    }

    @Override
    public void updateUserPassword(String userName, int changedPassword) {
        connection = databaseConnection.openConnection();
        String updatePasswordQuery = "UPDATE  login SET userPassword = ? WHERE userName = ?";
        try {
            preparedStatement = connection.prepareStatement(updatePasswordQuery);
            preparedStatement.setInt(1, changedPassword);
            preparedStatement.setString(2, userName);

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
    }

}
