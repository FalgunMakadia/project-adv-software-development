package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.ProfileAbstract;

public class PassPortNumberCommand extends FormCommand {
    private final String COMMAND_LABEL = "Passport Number";

    public PassPortNumberCommand(ProfileAbstract profileAbstract) {
        super(profileAbstract);
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
