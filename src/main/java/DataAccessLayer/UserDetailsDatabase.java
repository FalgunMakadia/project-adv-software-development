package DataAccessLayer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

import static org.mockito.Mockito.mock;

import java.sql.*;

public class UserDetailsDatabase implements IUserDetailsDatabase {
    private Connection connection;
    private PreparedStatement preparedStatement = null;

    public UserDetailsDatabase() throws IOException {
        connection = DatabaseConnection.instance();
    }

    public ResultSet validateUser(String username, int password) {
        ResultSet resultSet = null;

        return resultSet;
    }

    @Override
    public int insertNewUser() {
        return 0;
    }

    @Override
    public void UpdatePassword(String userName, String newPassword) {
        String updatePasswordQuery = "Update  FROM login SET userPassword = '" + newPassword+ "' WHERE userName = '" + userName + "'";
        try {
            preparedStatement = connection.prepareStatement(updatePasswordQuery);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

}
