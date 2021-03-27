package BusinessLogicLayer.CustomerAction;

import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;
import DataAccessLayer.IUserDetailsDatabase;
import BusinessLogicLayer.CommonAction.Action;

import java.io.IOException;
import java.sql.SQLException;

public class UpdatePassword extends Action {
    UpdatePassword updatePassword;
    String newpassword;

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }


    private static final String menuLabel = "Update Password";
    IUserDetailsDatabase userDatabase = null;


    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }

    @Override
    public void performAction()  {
        setCurrentPageInContext();
        userInterface.displayMessage("Update Password");
        String userName = loggedInUserContext.getUserName();
        try {
            IDatabaseFactory databaseFactory = new DatabaseFactory();
            IUserDetailsDatabase userDetailsDatabase = databaseFactory.createLoginDatabase();
            userInterface.displayMessage("Hello " + userName);
            String newPassword = userInterface.getMandatoryUserInput("New Password*: ");
            String ConfirmPassword = userInterface.getMandatoryUserInput("Confirm New Password*: ");
            if (newPassword.equals(ConfirmPassword))
                newPassword.hashCode();
            updatePassword.setNewpassword(newPassword);
            userInterface.displayMessage(userName + " your new  password is updated: ");
            userInterface.insertEmptyLine();
            userInterface.insertEmptyLine();
            userDatabase.UpdatePassword(userName, newPassword);
        } catch (IOException e)
        {
            e.printStackTrace();
        }



    }
}

