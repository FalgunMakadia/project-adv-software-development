package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class MiddleNameCommand extends FormCommand {
    private final String FIELD_NAME = "Middle Name";

    public MiddleNameCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getUserInput("Enter New Middle Name: ");
        user.setMiddleName(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getMiddleName();
    }

    @Override
    public String getLabel() {
        return FIELD_NAME;
    }
}
