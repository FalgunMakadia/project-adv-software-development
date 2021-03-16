package DAL;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

import static org.mockito.Mockito.mock;
import java.sql.*;

public class LoginDatabase implements ILoginDatabase{
    private Connection con = null;
    private PreparedStatement preparedStatement = null;
    public LoginDatabase() throws IOException {
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

    public void validateUser (String username, String password){
        String loginQuery = "SELECT * FROM t_User WHERE userName = " + username + " AND password = " + password;
        try {
            preparedStatement = con.prepareStatement(loginQuery);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
    public ResultSet operateSelect() {
        // write select query to get the details from the t_user table
        ResultSet resultSet = null;
        resultSet = mock(ResultSet.class);

        return resultSet;
    }
}
