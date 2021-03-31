package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class LastNameCommand extends FormCommand {
    private final String COMMAND_LABEL = "Last Name";

    public LastNameCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Last Name*: ");
        user.setLastName(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getLastName();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
