package BLL.CommonAction;

import BLL.User.User;
import DAL.ExecuteDatabase;
import DAL.LoginDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private User user;
    private String username;
    private String password;
    private String authLevel;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
        LoginDatabase loginDatabase = new LoginDatabase(this.username, this.password);
        ExecuteDatabase executeDatabase = new ExecuteDatabase();
        try {
            ResultSet resultSet = executeDatabase.executeSelect(loginDatabase);
            if (resultSet != null) {
                createUser(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

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
