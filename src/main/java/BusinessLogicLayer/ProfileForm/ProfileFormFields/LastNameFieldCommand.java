package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.AbstractFormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;

public class LastNameFieldCommand extends AbstractFormCommand {
    private final String COMMAND_LABEL = "Last Name";

    public LastNameFieldCommand(AbstractProfile profile) {
        super(profile);
    }

    public LastNameFieldCommand(AbstractProfile profile, IUserInterfacePage userInterfacePage) {
        super(profile);
        this.userInterface = userInterfacePage;
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
