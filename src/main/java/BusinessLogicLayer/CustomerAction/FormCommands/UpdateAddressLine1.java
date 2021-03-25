package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdateAddressLine1 extends FormCommand {
    private final String FIELD_LABEL = "Address Line 1";
    public UpdateAddressLine1(User user) {
        super(user);
    }

    @Override
    public void execute() {
        userInterface.displayMessage("Your Address Line 1 is: " + user.getAddressLine1());
        String userInput = userInterface.getMandatoryUserInput("Enter Address Line 1*: ");
        user.setAddressLine1(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getAddressLine1();
    }

    @Override
    public String getLabel() {
        return FIELD_LABEL;
    }
}
