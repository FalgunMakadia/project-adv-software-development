package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.AbstractAction;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;


public class UpdatePasswordAction extends AbstractAction {
    private static final String ACTION_TITLE = "Update Password";
    String newPassword;
    String confirmPassword;

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
        newPassword = userInterface.getMandatoryUserInput("New Password*: ");
        confirmPassword = userInterface.getMandatoryUserInput("Confirm New Password*: ");
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