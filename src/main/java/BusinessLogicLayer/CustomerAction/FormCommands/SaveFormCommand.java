package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.sql.SQLException;

public class SaveFormCommand extends FormCommand {
    private final String CHANGE_REQUEST = "change personal details";
    private final String COMMAND_LABEL = "Save Details";

    public SaveFormCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
        try {
            WorklistRequest worklistRequest = new WorklistRequest(CHANGE_REQUEST,
                    user.getAccountNumber(),
                    user);
            int worklistId = worklistDatabase.addWorkListRequest(worklistRequest);
            if(worklistId == 0) {
                userInterface.displayMessage("There is an error in submitting request");
            } else {
                userInterface.displayMessage("Request is generated with ID: " + worklistId + "\n");
            }
            loggedInUserContext.setCurrentPage("");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
