package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdateAddressLine2 extends FormCommand {
    private final String FIELD_LABEL = "Address Line 2";
    public UpdateAddressLine2(User user) {
        super(user);
    }

    @Override
    public void execute() {
        userInterface.displayMessage("Your Address Line 2 is: " + user.getAddressLine2());
        String userInput = userInterface.getUserInput("Enter Address Line 2: ");
        user.setAddressLine2(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getAddressLine2();
    }

    @Override
    public String getLabel() {
        return FIELD_LABEL;
    }
}
