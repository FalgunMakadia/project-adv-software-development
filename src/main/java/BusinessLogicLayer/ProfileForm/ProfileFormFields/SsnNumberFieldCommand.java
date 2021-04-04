package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.AbstractProfile;

public class SsnNumberFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "SSN Number";

    public SsnNumberFieldCommand(AbstractProfile profile) {
        super(profile);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter SSN*: ");
        profile.setSsnNo(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getSsnNo();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
