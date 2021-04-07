package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;

public class CityFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "City";

    public CityFieldCommand(AbstractProfile profile) {
        super(profile);
    }

    public CityFieldCommand(AbstractProfile profile, IUserInterfacePage userInterfacePage) {
        super(profile);
        this.userInterface = userInterfacePage;
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter New City*: ");
        profile.setCity(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getCity();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
