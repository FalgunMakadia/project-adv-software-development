package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdateLastName extends FormCommand {
    private final String FIELD_NAME = "Last Name";
    public UpdateLastName(User user) {
        super(user);
    }

    @Override
    public void execute() {
        userInterface.displayMessage("Your Last Name is: " + user.getLastName());
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
