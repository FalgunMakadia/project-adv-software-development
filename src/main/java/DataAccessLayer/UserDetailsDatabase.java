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
    private Connection con = null;
    private PreparedStatement preparedStatement = null;
    public UserDetailsDatabase() throws IOException {
       //FileReader reader=new FileReader("db.properties");
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String url = properties.getProperty("db.url");
        String dbUsername = properties.getProperty("db.username");
        String dbPassword = properties.getProperty("db.password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con =DriverManager.getConnection(
                    "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_7_DEVINT?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","CSCI5308_7_DEVINT_USER","ArUaPzseJd3xcNDq");

        } catch (SQLException exception) {
            System.out.println(exception);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ResultSet validateUser (String username, int password){
        ResultSet resultSet = null;
        String loginQuery = "SELECT * FROM login WHERE userName = '"+ username +"' AND userPassword = '" + password + "'";
        try {
            preparedStatement = con.prepareStatement(loginQuery);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultSet;
    }

}
