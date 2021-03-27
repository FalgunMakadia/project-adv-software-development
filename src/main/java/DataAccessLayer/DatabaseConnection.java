package DataAccessLayer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection;

    static {
        InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String driverClassname = properties.getProperty("db.driverClassName");
        String url = properties.getProperty("db.url");
        String dbUsername = properties.getProperty("db.username");
        String dbPassword = properties.getProperty("db.password");

        try {
            Class.forName(driverClassname);

            connection = DriverManager.getConnection(
                    url + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    dbUsername,
                    dbPassword);

        } catch (SQLException exception) {
            System.out.println(exception);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection instance() {
        return connection;
    }
}
