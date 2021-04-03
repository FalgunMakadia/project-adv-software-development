package BusinessLogicLayer.BankAction.FormActionCommands;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import DataAccessLayer.IUserDetailsDatabase;

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
        if (affectedRows > 0) {
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
        WorklistRequest worklistRequest = new WorklistRequest();
        worklistRequest.setRequestType("Open New Account");
        worklistRequest.setUser(profile);
        workListId = worklistDatabase.addWorkListRequest(worklistRequest);
        return workListId;
    }

    private int createNewUser() {
        String userName = profile.getUserName();
        int defaultPassword = profile.generateDefaultPassword();
        IUserDetailsDatabase userDatabase = null;
        userDatabase = databaseFactory.createUserDatabase();
        int affectedRows = userDatabase.insertNewUser(userName, defaultPassword, profile.getProfileRole());
        return affectedRows;
    }

    @Override
    public String getCommandLabel() {
        return menuLabel;
    }

}
