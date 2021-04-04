package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.ProfileAbstract;

public class AddressLine1FieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "Address Line 1";

    public AddressLine1FieldCommand(ProfileAbstract profile) {
        super(profile);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Address Line 1*: ");
        profile.setAddressLine1(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getAddressLine1();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
