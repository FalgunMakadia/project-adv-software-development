package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.ProfileAbstract;

public class LastNameFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "Last Name";

    public LastNameFieldCommand(ProfileAbstract profile) {
        super(profile);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Last Name*: ");
        profile.setLastName(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getLastName();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
