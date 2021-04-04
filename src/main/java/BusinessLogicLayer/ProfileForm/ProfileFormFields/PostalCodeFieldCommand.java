package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.ProfileAbstract;

public class PostalCodeFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "Postal Code";

    public PostalCodeFieldCommand(ProfileAbstract profile) {
        super(profile);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Postal Code*: ");
        profile.setPostalCode(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getPostalCode();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
