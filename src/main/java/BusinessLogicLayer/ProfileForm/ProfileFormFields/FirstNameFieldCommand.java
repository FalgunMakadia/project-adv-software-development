package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.ProfileAbstract;

public class FirstNameFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "First Name";

    public FirstNameFieldCommand(ProfileAbstract profile) {
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
