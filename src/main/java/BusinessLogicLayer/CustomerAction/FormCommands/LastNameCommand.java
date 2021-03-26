package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class LastNameCommand extends FormCommand {
    private final String FIELD_NAME = "Last Name";

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
    public String getLabel() {
        return FIELD_NAME;
    }
}
