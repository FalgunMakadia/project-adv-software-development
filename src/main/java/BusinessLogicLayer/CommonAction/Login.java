package BusinessLogicLayer.CommonAction;

import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import BusinessLogicLayer.User.LoggedInUserContext;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;

public class Login implements ILogin {
    private IUserProfileDatabase userProfileDatabase;
    private LoggedInUserContext loggedInUserContext;

    public Login() {
        loggedInUserContext = LoggedInUserContext.instance();

        IDatabaseFactory databaseFactory = new DatabaseFactory();
        IProfileDatabaseFactory profileDatabaseFactory = databaseFactory.createProfileDatabaseFactory();
        userProfileDatabase = profileDatabaseFactory.createUserProfileDatabase();
    }

    public void validateUser(String userName, String password) {
        int hashedPassword = password.hashCode();
        userProfileDatabase.validateUser(userName, hashedPassword);
    }

    public boolean checkStatus() {
        return loggedInUserContext.getActiveStatus();
    }

    public String getUserRole() {
        return loggedInUserContext.getUserRole();
    }
}
