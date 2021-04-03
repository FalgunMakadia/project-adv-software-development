package DataAccessLayer;

import BusinessLogicLayer.User.LoggedInUserContext;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection implements IDatabaseConnection {
    private static DatabaseConnection uniqueInstance;
    private static Connection connection;
    private static String driverClassname;
    private static String url;
    private static String dbUsername;
    private static String dbPassword;

    private DatabaseConnection() {
        InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driverClassname = properties.getProperty("db.driverClassName");
        url = properties.getProperty("db.url");
        dbUsername = properties.getProperty("db.username");
        dbPassword = properties.getProperty("db.password");

        try {
            Class.forName(driverClassname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new DatabaseConnection();
        }
        return uniqueInstance;
    }

    public Connection openConnection() {
        try {
            connection = DriverManager.getConnection(
                    url + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    dbUsername,
                    dbPassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
