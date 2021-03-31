package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class SSNNumberCommand extends FormCommand {
    private final String COMMAND_LABEL = "SSN Number";

    public SSNNumberCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter SSN*: ");
        user.setSsnNo(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getSsnNo();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
