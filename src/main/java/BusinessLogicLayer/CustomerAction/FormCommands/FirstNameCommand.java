package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class FirstNameCommand extends FormCommand {
    private final String COMMAND_LABEL = "First Name";

    public FirstNameCommand(User user) {
        super(user);
    }

    public FirstNameCommand() {
        super();
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter First Name*: ");
        user.setFirstName(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getFirstName();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }

}
