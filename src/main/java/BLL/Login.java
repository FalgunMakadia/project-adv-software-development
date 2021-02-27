package BLL;

import BLL.User.User;
import DAL.ExecuteDatabase;
import DAL.LoginDatabase;

import java.sql.ResultSet;

public class Login {
    private  User user;
    private String username;
    private String password;

    public Login(String username, String password){
        LoginDatabase loginDatabase = new LoginDatabase();
        ExecuteDatabase executeDatabase = new ExecuteDatabase();
        ResultSet rs = executeDatabase.executeSelect(loginDatabase);
        if(rs != null)
            createUser(rs);
        this.username = username;
        this.password = password;
    }
    private void createUser(ResultSet rs){

    }

    public Boolean validUser() {
        System.out.println(username + password);
        if(this.username.equals("admin") && this.password.equals("admin")) {
            return true;
        } else {
            return false;
        }
    }
}
