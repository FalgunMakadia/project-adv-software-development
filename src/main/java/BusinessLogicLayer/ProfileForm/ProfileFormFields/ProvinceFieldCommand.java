package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.AbstractFormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;

public class ProvinceFieldCommand extends AbstractFormCommand {
    private final String COMMAND_LABEL = "Province";

    public ProvinceFieldCommand(AbstractProfile profile) {
        super(profile);
    }

    public ProvinceFieldCommand(AbstractProfile profile, IUserInterfacePage userInterfacePage) {
        super(profile);
        this.userInterface = userInterfacePage;
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Province*: ");
        profile.setProvince(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getProvince();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
