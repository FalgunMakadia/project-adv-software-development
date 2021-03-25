package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdateContact extends FormCommand {
    private final String FIELD_LABEL = "Contact";
    public UpdateContact(User user) {
        super(user);
    }

    @Override
    public void execute() {
        userInterface.displayMessage("Your Contact Number is: " + user.getContact());
        String userInput = userInterface.getMandatoryLongUserInputWithMinimumRange("Enter Contact Number*: ", 10);
        user.setContact(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getContact();
    }

    @Override
    public String getLabel() {
        return FIELD_LABEL;
    }
}
