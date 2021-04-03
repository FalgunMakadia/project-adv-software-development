package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.ProfileAbstract;

public class CityCommand extends FormCommand {
    private final String COMMAND_LABEL = "City";

    public CityCommand(ProfileAbstract profileAbstract) {
        super(profileAbstract);
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
