package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.WorkListRequestActions.IWorkListRequestActionFactory;
import BusinessLogicLayer.WorkListRequestActions.IWorkListRequest;
import BusinessLogicLayer.WorkListRequestActions.WorkListRequestActionFactory;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;

public class SaveNewAccountProfileFormActionCommand extends FormCommand {
    private static final String COMMAND_LABEL = "Save";
    private static final String COMMAND_TYPE = "ACTION";
    private static final String PRIORITY = "medium";
    private static final String WORKLIST_REQUEST_TYPE = "Open New Account";

    private IProfileDatabaseFactory profileDatabaseFactory;
    private IUserProfileDatabase userProfileDatabase;
    private IWorkListRequestActionFactory workListActionFactory;

    public SaveNewAccountProfileFormActionCommand(AbstractProfile newCustomerProfile) {
        super();
        this.profile = newCustomerProfile;
        workListActionFactory = new WorkListRequestActionFactory();

        profileDatabaseFactory = databaseFactory.createProfileDatabaseFactory();
        userProfileDatabase = profileDatabaseFactory.createUserProfileDatabase();
    }

    public SaveNewAccountProfileFormActionCommand(AbstractProfile profile, IUserProfileDatabase userProfileDatabase) {
        this.userProfileDatabase = userProfileDatabase;
        this.profile = profile;
    }

    @Override
    public void execute() {

        int affectedRows = createNewUser();
        if (affectedRows > 0) {
            int workListID = createNewWorkListRequest();
            userInterface.displayMessage("Account Creation Request has been raised");
            userInterface.displayMessage("Your request Id is: " + String.valueOf(workListID));
        }
        loggedInUserContext.clearCurrentPage();

    }

    @Override
    public String getFieldValue() {
        return COMMAND_TYPE;
    }

    private int createNewWorkListRequest() {
        int workListId = 0;
        IWorkListRequest workListRequest = workListActionFactory.createWorkListRequest();
        workListRequest.setPriority(PRIORITY);
        workListRequest.setRequestType(WORKLIST_REQUEST_TYPE);
        workListRequest.setUser(profile);
        workListId = workListOperationDatabase.addWorkListRequest(workListRequest);
        return workListId;
    }

    private int createNewUser() {
        String userName = profile.getUserName();
        String defaultPassword = String.valueOf(profile.generateDefaultPassword());
        String profileRole = profile.getProfileRole();
        int affectedRows = userProfileDatabase.addNewUser(userName, defaultPassword, profileRole);
        return affectedRows;
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }

}
