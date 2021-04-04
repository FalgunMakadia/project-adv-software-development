package DataAccessLayer;

import BusinessLogicLayer.User.LoggedInUserContext;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection implements IDatabaseConnection {
    private static final String CONFIG_FILE_NAME = "config.properties";
    private static final String DRIVER_CLASS_NAME = "db.driverClassName";
    private static final String DATABASE_URL  = "db.url";
    private static final String DATABASE_USERNAME  = "db.username";
    private static final String DATABASE_PASSWORD = "db.password";
    private static final String DATABASE_OPTIONAL_PARAMETERS  = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private static DatabaseConnection uniqueInstance;
    private static Connection connection;
    private static String driverClassname;
    private static String url;
    private static String dbUsername;
    private static String dbPassword;

    private DatabaseConnection() {
        InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driverClassname = properties.getProperty(DRIVER_CLASS_NAME);
        url = properties.getProperty(DATABASE_URL);
        dbUsername = properties.getProperty(DATABASE_USERNAME);
        dbPassword = properties.getProperty(DATABASE_PASSWORD);

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
                    url + DATABASE_OPTIONAL_PARAMETERS,
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
