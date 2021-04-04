package BusinessLogicLayer.CommonAction;

import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import BusinessLogicLayer.User.LoggedInUserContext;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;

public class SignInAction implements ISignInAction {
    private IUserProfileDatabase userProfileDatabase;
    private LoggedInUserContext loggedInUserContext;

    public SignInAction() {
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
