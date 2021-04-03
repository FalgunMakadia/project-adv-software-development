package BusinessLogicLayer.CommonAction;

import DataAccessLayer.DatabaseFactory;
import BusinessLogicLayer.User.LoggedInUserContext;
import DataAccessLayer.IUserDetailsDatabase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login implements ILogin {
    private IUserDetailsDatabase loginDatabase = null;
    private LoggedInUserContext loggedInUserContext;

    public Login() {
        DatabaseFactory databaseFactory = new DatabaseFactory();
        loggedInUserContext = LoggedInUserContext.instance();

        loginDatabase = databaseFactory.createUserDatabase();
    }

    public void validateUser(String userName, String password) {
        int hashedPassword = password.hashCode();
        loginDatabase.validateUser(userName, hashedPassword);
    }

    public boolean checkStatus() {
        return loggedInUserContext.getActiveStatus();
    }

    public String getUserRole() {
        return loggedInUserContext.getUserRole();
    }
}
