package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.AbstractFormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;

public class ContactFieldCommand extends AbstractFormCommand {
    private final String COMMAND_LABEL = "Contact";

    public ContactFieldCommand(AbstractProfile profile) {
        super(profile);
    }

    public ContactFieldCommand(AbstractProfile profile, IUserInterfacePage userInterfacePage) {
        super(profile);
        this.userInterface = userInterfacePage;
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
