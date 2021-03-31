package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class PassPortNumberCommand extends FormCommand {
    private final String COMMAND_LABEL = "Passport Number";

    public PassPortNumberCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Passport Number*: ");
        user.setPassport(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getPassport();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
