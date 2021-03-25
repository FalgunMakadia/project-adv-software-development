package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdateFirstName extends FormCommand {
    private final String FIELD_LABEL = "First Name";
    public UpdateFirstName(User user) {
        super(user);
    }

    @Override
    public void execute() {
        userInterface.displayMessage("Your First Name is: " + user.getFirstName());
        String userInput = userInterface.getMandatoryUserInput("Enter New First Name*: ");
        user.setFirstName(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getFirstName();
    }

    @Override
    public String getLabel() {
        return FIELD_LABEL;
    }
}
