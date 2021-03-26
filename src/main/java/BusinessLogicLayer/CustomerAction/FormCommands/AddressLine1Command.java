package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class AddressLine1Command extends FormCommand {
    private final String FIELD_LABEL = "Address Line 1";

    public AddressLine1Command(User user) {
        super(user);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Address Line 1*: ");
        user.setAddressLine1(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getAddressLine1();
    }

    @Override
    public String getMenuLabel() {
        return FIELD_LABEL;
    }
}
