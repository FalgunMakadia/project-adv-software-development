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
    public int insertNewUser() {
        return 0;
    }

}
