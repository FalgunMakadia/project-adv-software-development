package DataAccessLayer;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.*;

public class UserDetailsDatabase implements IUserDetailsDatabase {
    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private IDatabaseConnection databaseConnection;
    private ILoggedInUserContext loggedInUserContext;

    public UserDetailsDatabase() {
        databaseConnection = DatabaseConnection.instance();
        loggedInUserContext = LoggedInUserContext.instance();
    }

    public void validateUser(String username, int password) {
        connection = databaseConnection.openConnection();
        ResultSet resultSet = null;
        String loginQuery = "SELECT * FROM login WHERE userName = '" + username + "' AND userPassword = '" + password + "'";
        try {
            preparedStatement = connection.prepareStatement(loginQuery);
            resultSet = preparedStatement.executeQuery();
            createLoggedInUserContext(resultSet);

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
    }

    @Override
    public int insertNewUser(String userName, int defaultPassword, String userRole) {
        connection = databaseConnection.openConnection();
        int affectedRow = 0;
        String query = "INSERT INTO login VALUES (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,String.valueOf(defaultPassword));
            preparedStatement.setString(3,null);
            preparedStatement.setString(4,userRole);
            preparedStatement.setBoolean(5,false);
            affectedRow = preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return affectedRow;
    }

    @Override
    public void UpdatePassword(String userName, int changedPassword) {
        connection = databaseConnection.openConnection();
        String updatePasswordQuery = "UPDATE  login SET userPassword = '" + changedPassword+ "' WHERE userName = '" + userName + "'";
        try {
            preparedStatement = connection.prepareStatement(updatePasswordQuery);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
    }

    private void createLoggedInUserContext(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                loggedInUserContext.setUserName(resultSet.getString("userName"));
                loggedInUserContext.setUserRole(resultSet.getString("userRole"));
                loggedInUserContext.setAccountNumber(resultSet.getString("accountNumber"));
                loggedInUserContext.setActiveStatus(resultSet.getBoolean("ActiveStatus"));
                loggedInUserContext.setLoginStatus(true);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
