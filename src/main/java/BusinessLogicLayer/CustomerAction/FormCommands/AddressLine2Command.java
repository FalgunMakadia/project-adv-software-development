package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class AddressLine2Command extends FormCommand {
    private final String COMMAND_LABEL = "Address Line 2";

    public AddressLine2Command(User user) {
        super(user);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getUserInput("Enter Address Line 2: ");
        user.setAddressLine2(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getAddressLine2();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
