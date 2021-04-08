package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.AbstractFormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.WorkListRequestActions.IWorkListRequestActionFactory;
import BusinessLogicLayer.WorkListRequestActions.IWorkListRequest;
import BusinessLogicLayer.WorkListRequestActions.WorkListRequestActionFactory;
import DataAccessLayer.OperationDatabase.IWorklistOperationDatabase;

public class SaveUpdatedPersonalDetailFormActionCommand extends AbstractFormCommand {
    private static final String COMMAND_TYPE = "ACTION";
    private final String CHANGE_REQUEST = "Change Personal Details";
    private final String COMMAND_LABEL = "Save";
    IWorkListRequest workListRequest;

    public SaveUpdatedPersonalDetailFormActionCommand(AbstractProfile profile) {
        super(profile);
        IWorkListRequestActionFactory workListActionFactory = new WorkListRequestActionFactory();
        workListRequest = workListActionFactory.createWorkListRequest(CHANGE_REQUEST,
                profile.getAccountNumber(),
                profile);
    }

    public SaveUpdatedPersonalDetailFormActionCommand(AbstractProfile profile, IWorklistOperationDatabase workListOperationDatabase) {
        super(profile);
        this.workListOperationDatabase = workListOperationDatabase;

    }

    @Override
    public void execute() {
        int workListId = workListOperationDatabase.addWorkListRequest(workListRequest);
        if (workListId == 0) {
            userInterface.displayMessage("There is an error in submitting request");
        } else {
            userInterface.displayMessage("Request is generated with ID: " + workListId + "\n");
        }
        loggedInUserContext.clearCurrentPage();
    }

    @Override
    public String getFieldValue() {
        return COMMAND_TYPE;
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
