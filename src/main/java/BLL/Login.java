package BLL;

import BLL.User.User;
import DAL.ExecuteDatabase;
import DAL.LoginDatabase;

import java.sql.ResultSet;

public class Login {
    private  User user;
    private String username;
    private String password;
    private String authLevel;

    public Login(String username, String password, String authLevel){
        LoginDatabase loginDatabase = new LoginDatabase();
        ExecuteDatabase executeDatabase = new ExecuteDatabase();
        ResultSet rs = executeDatabase.executeSelect(loginDatabase);
        if(rs != null)
            createUser(rs);
        this.username = username;
        this.password = password;
        this.authLevel = authLevel;
    }
    private void createUser(ResultSet rs){

    }

    public String validUser() {

        if(this.authLevel.equals("E") && this.username.equals("admin") && this.password.equals("admin")) {
            return "E";
        } else if(this.authLevel.equals("C") && !this.username.equals("") && !this.username.equals("admin") && this.username.equals(this.password)) {
            return "C";
        } else {
            return "";
        }
    }
}
