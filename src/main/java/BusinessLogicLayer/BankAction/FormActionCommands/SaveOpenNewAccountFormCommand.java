package BusinessLogicLayer.BankAction.FormActionCommands;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import DataAccessLayer.IUserDetailsDatabase;

import java.io.IOException;
import java.sql.SQLException;

public class SaveOpenNewAccountFormCommand extends FormCommand {
    private String menuLabel;

    public SaveOpenNewAccountFormCommand(String menuLabel, ProfileAbstract newCustomerProfile) {
        super();
        this.menuLabel = menuLabel;
        this.profile = newCustomerProfile;
    }

    @Override
    public void execute() {

        int affectedRows = createNewUser();
        if(affectedRows>0) {
            int workListID = createNewWorkListRequest();
            userInterface.displayMessage("Account Creation Request has been raised");
            userInterface.displayMessage("Your request Id is: " + String.valueOf(workListID));
        }
        loggedInUserContext.setCurrentPage("");

    }

    @Override
    public String getFieldValue() {
        return null;
    }

    private int createNewWorkListRequest() {
        int workListId = 0;
        try {
            WorklistRequest worklistRequest = new WorklistRequest();
            worklistRequest.setRequestType("Open New Account");
            worklistRequest.setUser(profile);
            workListId = worklistDatabase.addWorkListRequest(worklistRequest);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return workListId;
    }

    private int createNewUser() {
        String userName = profile.getUserName();
        int defaultPassword = profile.generateDefaultPassword();
        IUserDetailsDatabase userDatabase = null;
        try {
            userDatabase = databaseFactory.createUserDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int affectedRows = userDatabase.insertNewUser(userName, defaultPassword, profile.getProfileRole());
        return  affectedRows;
    }

    @Override
    public String getCommandLabel() {
        return menuLabel;
    }

}
