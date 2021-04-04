package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import DataAccessLayer.ProfileDatabase.ICustomerProfileDatabase;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;


public class UpdatePassword extends Action {
    private static final String menuLabel = "Update Password";

    private IProfileDatabaseFactory profileDatabaseFactory;
    private IUserProfileDatabase userProfileDatabase;

    public UpdatePassword() {
        profileDatabaseFactory = databaseFactory.createProfileDatabaseFactory();
        userProfileDatabase = profileDatabaseFactory.createUserProfileDatabase();
    }

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    public void performAction() {
        setCurrentPageInContext();
        userInterface.displayMessage("Update Password");
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
        loggedInUserContext.setCurrentPage(menuLabel);
    }
}