package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.ProfileAbstract;

public class CityFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "City";

    public CityFieldCommand(ProfileAbstract profile) {
        super(profile);
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
