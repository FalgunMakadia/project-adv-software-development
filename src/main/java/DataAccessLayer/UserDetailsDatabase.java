package DataAccessLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.*;

public class UserDetailsDatabase implements IUserDetailsDatabase {
    private Connection connection;
    private PreparedStatement preparedStatement = null;

    public UserDetailsDatabase() throws IOException {
        connection = DatabaseConnection.instance();
    }

    public ResultSet validateUser(String username, int password) {
        ResultSet resultSet = null;
        String loginQuery = "SELECT * FROM login WHERE userName = '" + username + "' AND userPassword = '" + password + "'";
        try {
            preparedStatement = connection.prepareStatement(loginQuery);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public int insertNewUser(String userName, int defaultPassword, String userRole) {
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
        }
        return affectedRow;
    }



    @Override
    public void UpdatePassword(String userName, int changedPassword) {
        String updatePasswordQuery = "UPDATE  login SET userPassword = '" + changedPassword+ "' WHERE userName = '" + userName + "'";
        try {
            preparedStatement = connection.prepareStatement(updatePasswordQuery);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }


}
