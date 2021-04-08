package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;

public class AddressLine2FieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "Address Line 2";

    public AddressLine2FieldCommand(AbstractProfile profile) {
        super(profile);
    }

    public AddressLine2FieldCommand(AbstractProfile profile, IUserInterfacePage userInterfacePage) {
        super(profile);
        this.userInterface = userInterfacePage;
    }

    @Override
    public void execute() {
        String userInput = userInterface.getUserInput("Enter Address Line 2: ");
        profile.setAddressLine2(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getAddressLine2();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
