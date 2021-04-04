package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;


public class UpdatePasswordAction extends Action {
    private static final String ACTION_TITLE = "Update Password";

    private IProfileDatabaseFactory profileDatabaseFactory;
    private IUserProfileDatabase userProfileDatabase;

    public UpdatePasswordAction() {
        profileDatabaseFactory = databaseFactory.createProfileDatabaseFactory();
        userProfileDatabase = profileDatabaseFactory.createUserProfileDatabase();
    }

    @Override
    public String getActionTitle() {
        return ACTION_TITLE;
    }

    @Override
    public void performAction() {
        setCurrentPageInContext();
        userInterface.displayMessage(ACTION_TITLE);
        String userName = loggedInUserContext.getUserName();

        userInterface.displayMessage("Hello " + userName);
        String newPassword = userInterface.getMandatoryUserInput("New Password*: ");
        String confirmPassword = userInterface.getMandatoryUserInput("Confirm New Password*: ");
        if (newPassword.equals(confirmPassword)) {
            int changedPassword = newPassword.hashCode();
            userProfileDatabase.updateUserPassword(userName, changedPassword);
            userInterface.displayMessage(userName + " your new  password is updated: ");
        } else {
            userInterface.displayMessage("Password did not match");
        }
        userInterface.insertEmptyLine();
        userInterface.insertEmptyLine();
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(ACTION_TITLE);
    }
}