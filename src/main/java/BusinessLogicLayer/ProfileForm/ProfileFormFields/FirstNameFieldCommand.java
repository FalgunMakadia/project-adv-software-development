package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.AbstractProfile;

public class FirstNameFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "First Name";

    public FirstNameFieldCommand(AbstractProfile profile) {
        super(profile);
    }


    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter First Name*: ");
        profile.setFirstName(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getFirstName();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }

}
