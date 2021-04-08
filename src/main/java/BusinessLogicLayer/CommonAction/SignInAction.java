package BusinessLogicLayer.CommonAction;

import BusinessLogicLayer.User.UserFactory;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import BusinessLogicLayer.User.ILoggedInUserContext;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;

public class SignInAction implements ISignInAction {
    private IUserProfileDatabase userProfileDatabase;
    private ILoggedInUserContext loggedInUserContext;
    private UserFactory userFactory;

    public SignInAction() {
        userFactory = new UserFactory();
        loggedInUserContext = userFactory.getLoggedInUserContext();

        IDatabaseFactory databaseFactory = new DatabaseFactory();
        IProfileDatabaseFactory profileDatabaseFactory = databaseFactory.createProfileDatabaseFactory();
        userProfileDatabase = profileDatabaseFactory.createUserProfileDatabase();
    }

    public SignInAction(IUserProfileDatabase userProfileDatabase) {
        this.userProfileDatabase = userProfileDatabase;
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
