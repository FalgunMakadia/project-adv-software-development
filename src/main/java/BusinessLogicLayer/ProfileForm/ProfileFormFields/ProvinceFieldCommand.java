package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.ProfileAbstract;

public class ProvinceFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "Province";

    public ProvinceFieldCommand(ProfileAbstract profile) {
        super(profile);
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
