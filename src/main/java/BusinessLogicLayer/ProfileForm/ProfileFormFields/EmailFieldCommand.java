package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.ProfileAbstract;

public class EmailFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "Email";

    public EmailFieldCommand(ProfileAbstract profile) {
        super(profile);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Email*: ");
        profile.setEmailAddress(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getEmailAddress();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
