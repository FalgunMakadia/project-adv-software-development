package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.ProfileAbstract;

public class AddressLine2Command extends FormCommand {
    private final String COMMAND_LABEL = "Address Line 2";

    public AddressLine2Command(ProfileAbstract profileAbstract) {
        super(profileAbstract);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getUserInput("Enter Address Line 2: ");
        profile.setAddressLine2(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getAddressLine2();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
