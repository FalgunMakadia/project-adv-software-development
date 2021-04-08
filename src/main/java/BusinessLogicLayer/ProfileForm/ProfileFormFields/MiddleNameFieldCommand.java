package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.AbstractFormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;

public class MiddleNameFieldCommand extends AbstractFormCommand {
    private final String COMMAND_LABEL = "Middle Name";

    public MiddleNameFieldCommand(AbstractProfile profile) {
        super(profile);
    }

    public MiddleNameFieldCommand(AbstractProfile profile, IUserInterfacePage userInterfacePage) {
        super(profile);
        this.userInterface = userInterfacePage;
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
