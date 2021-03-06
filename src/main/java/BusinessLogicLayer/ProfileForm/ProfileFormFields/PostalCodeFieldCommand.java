package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.AbstractFormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;

public class PostalCodeFieldCommand extends AbstractFormCommand {
    private final String COMMAND_LABEL = "Postal Code";

    public PostalCodeFieldCommand(AbstractProfile profile) {
        super(profile);
    }

    public PostalCodeFieldCommand(AbstractProfile profile, IUserInterfacePage userInterfacePage) {
        super(profile);
        this.userInterface = userInterfacePage;
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Postal Code*: ");
        profile.setPostalCode(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getPostalCode();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
