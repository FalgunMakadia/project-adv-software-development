package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;

public class FirstNameFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "First Name";

    public FirstNameFieldCommand(AbstractProfile profile) {
        super(profile);
    }

    public FirstNameFieldCommand(AbstractProfile profile, IUserInterfacePage userInterfacePage) {
        super(profile);
        this.userInterface = userInterfacePage;
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
