package BLL;

import BLL.User.User;
import DAL.ExecuteDatabase;
import DAL.LoginDatabase;

import java.sql.ResultSet;

public class Login {
    private  User user;

    public Login(String username, String password){
        LoginDatabase loginDatabase = new LoginDatabase();
        ExecuteDatabase executeDatabase = new ExecuteDatabase();
        ResultSet rs = executeDatabase.executeSelect(loginDatabase);
        if(rs != null)
            createUser(rs);

    }
    private void createUser(ResultSet rs){

    }
}
