package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.ProfileAbstract;

public class ProvinceCommand extends FormCommand {
    private final String COMMAND_LABEL = "Province";

    public ProvinceCommand(ProfileAbstract profileAbstract) {
        super(profileAbstract);
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
