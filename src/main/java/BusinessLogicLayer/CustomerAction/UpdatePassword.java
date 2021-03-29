package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;
import DataAccessLayer.IUserDetailsDatabase;

import java.io.IOException;


public class UpdatePassword extends Action {
    private static final String menuLabel = "Update Password";

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    public void performAction() {
        setCurrentPageInContext();
        userInterface.displayMessage("Update Password");
        String userName = loggedInUserContext.getUserName();
        try {
            IDatabaseFactory databaseFactory = new DatabaseFactory();
            IUserDetailsDatabase userDetailsDatabase = databaseFactory.createLoginDatabase();
            userInterface.displayMessage("Hello " + userName);
            String newPassword = userInterface.getMandatoryUserInput("New Password*: ");
            String confirmPassword = userInterface.getMandatoryUserInput("Confirm New Password*: ");
            if (newPassword.equals(confirmPassword)) {
                int changedPassword = newPassword.hashCode();
                userDetailsDatabase.UpdatePassword(userName, changedPassword);
                userInterface.displayMessage(userName + " your new  password is updated: ");
            }
            else{
                userInterface.displayMessage("Password did not match");
            }
            userInterface.insertEmptyLine();
            userInterface.insertEmptyLine();

        } catch (IOException throwables) {
            throwables.printStackTrace();


        }
        
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }
}