package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;

public class PassPortNumberFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "Passport Number";

    public PassPortNumberFieldCommand(AbstractProfile profile) {
        super(profile);
    }

    public PassPortNumberFieldCommand(AbstractProfile profile, IUserInterfacePage userInterfacePage) {
        super(profile);
        this.userInterface = userInterfacePage;
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Passport Number*: ");
        profile.setPassport(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getPassport();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
