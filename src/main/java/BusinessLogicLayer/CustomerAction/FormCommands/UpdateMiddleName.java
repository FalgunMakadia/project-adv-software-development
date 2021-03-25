package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdateMiddleName extends FormCommand {
    private final String FIELD_NAME = "Middle Name";
    public UpdateMiddleName(User user) {
        super(user);
    }

    @Override
    public void execute() {
        userInterface.displayMessage("Your Middle Name is " + user.getMiddleName());
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
