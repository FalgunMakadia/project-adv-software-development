package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.WorkListActions.IWorkListActionFactory;
import BusinessLogicLayer.WorkListActions.IWorkListRequest;
import BusinessLogicLayer.WorkListActions.WorkListActionFactory;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;

public class SaveNewAccountProfileFormActionCommand extends FormCommand {
    private String menuLabel;
    private IProfileDatabaseFactory profileDatabaseFactory;
    private IUserProfileDatabase userProfileDatabase;
    private IWorkListActionFactory workListActionFactory;
    public SaveNewAccountProfileFormActionCommand(String menuLabel, AbstractProfile newCustomerProfile) {
        super();
        this.menuLabel = menuLabel;
        this.profile = newCustomerProfile;
        workListActionFactory = new WorkListActionFactory();

        profileDatabaseFactory = databaseFactory.createProfileDatabaseFactory();
        userProfileDatabase = profileDatabaseFactory.createUserProfileDatabase();
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
        IWorkListRequest workListRequest = workListActionFactory.createWorkListRequest();
        workListRequest.setRequestType("Open New Account");
        workListRequest.setUser(profile);
        workListId = worklistOperationDatabase.addWorkListRequest(workListRequest);
        return workListId;
    }

    private int createNewUser() {
        String userName = profile.getUserName();
        String defaultPassword = String.valueOf(profile.generateDefaultPassword());
        int affectedRows = userProfileDatabase.addNewUser(userName, defaultPassword, profile.getProfileRole());
        return affectedRows;
    }

    @Override
    public String getCommandLabel() {
        return menuLabel;
    }

}
