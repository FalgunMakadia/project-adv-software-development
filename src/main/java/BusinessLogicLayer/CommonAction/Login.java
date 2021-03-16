package BusinessLogicLayer.CommonAction;

import BusinessLogicLayer.DatabaseFactory;
import BusinessLogicLayer.User.User;
import DAL.ExecuteDatabase;
import DAL.ILoginDatabase;
import DAL.LoginDatabase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private User user;
    private String username;
    private String password;
    private String authLevel;

    public Login(String username, String password) throws IOException {
        this.username = username;
        this.password = password;
        DatabaseFactory databaseFactory = new DatabaseFactory();
        ILoginDatabase loginDatabase = databaseFactory.createLoginDatabase();
        loginDatabase.validateUser(username, password);
        ExecuteDatabase executeDatabase = new ExecuteDatabase();
//        try {
//            ResultSet resultSet = executeDatabase.executeSelect(loginDatabase);
//            if (resultSet != null) {
//                createUser(resultSet);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

    }

    private void createUser(ResultSet rs) throws SQLException {
        //convert extract the status and auth access from the result set

        this.authLevel = rs.getString("authLevel");
        this.authLevel = "E";
    }

    public String validUser() {

        if (this.authLevel.equals("E") && this.username.equals("admin") && this.password.equals("admin")) {
            return "E";
        } else if (this.authLevel.equals("C") && !this.username.equals("") && !this.username.equals("admin") && this.username.equals(this.password)) {
            return "C";
        } else {
            return "";
        }
    }

    public String getAuthLevel() {
        return this.authLevel;
    }
}
