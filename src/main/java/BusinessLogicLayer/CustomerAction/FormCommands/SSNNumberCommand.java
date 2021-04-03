package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.ProfileAbstract;

public class SSNNumberCommand extends FormCommand {
    private final String COMMAND_LABEL = "SSN Number";

    public SSNNumberCommand(ProfileAbstract profileAbstract) {
        super(profileAbstract);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter SSN*: ");
        profile.setSsnNo(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getSsnNo();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
