package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;

public class EmailFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "Email";

    public EmailFieldCommand(AbstractProfile profile) {
        super(profile);
    }

    public EmailFieldCommand(AbstractProfile profile, IUserInterfacePage userInterfacePage) {
        super(profile);
        this.userInterface = userInterfacePage;
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
