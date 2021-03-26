package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class ContactCommand extends FormCommand {
    private final String FIELD_LABEL = "Contact";

    public ContactCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
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
