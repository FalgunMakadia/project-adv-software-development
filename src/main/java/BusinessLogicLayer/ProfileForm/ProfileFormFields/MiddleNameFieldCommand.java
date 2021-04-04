package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.ProfileAbstract;

public class MiddleNameFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "Middle Name";

    public MiddleNameFieldCommand(ProfileAbstract profile) {
        super(profile);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getUserInput("Enter Middle Name: ");
        profile.setMiddleName(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getMiddleName();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
