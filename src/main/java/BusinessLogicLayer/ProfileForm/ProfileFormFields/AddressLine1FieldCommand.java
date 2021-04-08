package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;

public class AddressLine1FieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "Address Line 1";

    public AddressLine1FieldCommand(AbstractProfile profile) {
        super(profile);
    }

    public AddressLine1FieldCommand(AbstractProfile profile, IUserInterfacePage userInterfacePage) {
        super(profile);
        this.userInterface = userInterfacePage;
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Address Line 1*: ");
        profile.setAddressLine1(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getAddressLine1();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
