package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.ProfileAbstract;

public class EmailCommand extends FormCommand {
    private final String COMMAND_LABEL = "Email";

    public EmailCommand(ProfileAbstract profileAbstract) {
        super(profileAbstract);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Email*: ");
        profile.setEmailAddress(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getEmailAddress();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
