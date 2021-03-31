package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class PostalCodeCommand extends FormCommand {
    private final String COMMAND_LABEL = "Postal Code";

    public PostalCodeCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Postal Code*: ");
        user.setPostalCode(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getPostalCode();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
