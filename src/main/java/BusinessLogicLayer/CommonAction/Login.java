package BusinessLogicLayer.CommonAction;

import DataAccessLayer.DatabaseFactory;
import BusinessLogicLayer.User.LoggedInUserContext;
import DataAccessLayer.ILoginDatabase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login implements ILogin {
    private ILoginDatabase loginDatabase = null;
    private LoggedInUserContext loggedInUserContext;
    public Login() {
        DatabaseFactory databaseFactory = new DatabaseFactory();
        loggedInUserContext = LoggedInUserContext.getInstance();

        try {
            loginDatabase = databaseFactory.createLoginDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void validateUser(String userName, String password) {
        int hashedPassword = password.hashCode();
        ResultSet resultSet = loginDatabase.validateUser(userName, hashedPassword);
        createLoggedInUserContext(resultSet);
    }

    private void createLoggedInUserContext(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                loggedInUserContext.setUserName(resultSet.getString("userName"));
                loggedInUserContext.setUserRole(resultSet.getString("userRole"));
                loggedInUserContext.setAccountNumber(resultSet.getString("accountNumber"));
                loggedInUserContext.setActiveStatus(resultSet.getBoolean("ActiveStatus"));
                loggedInUserContext.setLoginStatus(true);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public boolean checkStatus(){
        return loggedInUserContext.getActiveStatus();
    }

    public String getUserRole(){
        return loggedInUserContext.getUserRole();
    }
}
