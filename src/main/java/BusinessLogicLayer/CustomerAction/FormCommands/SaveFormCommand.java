package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.sql.SQLException;

public class SaveFormCommand extends FormCommand {
    private final String COMMAND_LABEL = "Save Details";

    public SaveFormCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
        try {
            WorklistRequest worklistRequest = new WorklistRequest("change",
                    user.getAccountNumber(),
                    user);
            worklistDatabase.addWorkListRequest(worklistRequest);
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
