package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.sql.SQLException;

public class SaveFormCommand extends FormCommand {
    private final String CHANGE_REQUEST = "Change Personal Details";
    private final String COMMAND_LABEL = "Save Details";

    public SaveFormCommand(ProfileAbstract profileAbstract) {
        super(profileAbstract);
    }

    @Override
    public void execute() {
        WorklistRequest worklistRequest = new WorklistRequest(CHANGE_REQUEST,
                profile.getAccountNumber(),
                profile);
        int worklistId = worklistDatabase.addWorkListRequest(worklistRequest);
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
