package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class MiddleNameCommand extends FormCommand {
    private final String COMMAND_LABEL = "Middle Name";

    public MiddleNameCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getUserInput("Enter Middle Name: ");
        user.setMiddleName(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getMiddleName();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
