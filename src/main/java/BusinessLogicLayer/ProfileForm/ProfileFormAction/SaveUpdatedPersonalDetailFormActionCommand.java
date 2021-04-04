package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.WorkListActions.IWorkListActionFactory;
import BusinessLogicLayer.WorkListActions.IWorkListRequest;
import BusinessLogicLayer.WorkListActions.WorkListActionFactory;

public class SaveUpdatedPersonalDetailFormActionCommand extends FormCommand {
    private final String CHANGE_REQUEST = "Change Personal Details";
    private final String COMMAND_LABEL = "Save Details";

    public SaveUpdatedPersonalDetailFormActionCommand(AbstractProfile profile) {
        super(profile);
    }

    @Override
    public void execute() {
        IWorkListActionFactory workListActionFactory = new WorkListActionFactory();
        IWorkListRequest workListRequest = workListActionFactory.createWorkListRequest(CHANGE_REQUEST,
                profile.getAccountNumber(),
                profile);
        int worklistId = worklistOperationDatabase.addWorkListRequest(workListRequest);
        if (worklistId == 0) {
            userInterface.displayMessage("There is an error in submitting request");
        } else {
            userInterface.displayMessage("Request is generated with ID: " + worklistId + "\n");
        }
        loggedInUserContext.setCurrentPage("");
    }

    @Override
    public String getFieldValue() {
        return null;
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
