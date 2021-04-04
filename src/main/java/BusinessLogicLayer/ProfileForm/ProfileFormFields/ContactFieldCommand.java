package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.ProfileAbstract;

public class ContactFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "Contact";

    public ContactFieldCommand(ProfileAbstract profile) {
        super(profile);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryLongUserInputWithMinimumRange("Enter Contact Number*: ", 10);
        profile.setContact(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getContact();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }

}
