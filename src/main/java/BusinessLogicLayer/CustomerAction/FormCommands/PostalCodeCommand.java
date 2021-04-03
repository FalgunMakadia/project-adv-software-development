package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.ProfileAbstract;

public class PostalCodeCommand extends FormCommand {
    private final String COMMAND_LABEL = "Postal Code";

    public PostalCodeCommand(ProfileAbstract profileAbstract) {
        super(profileAbstract);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Postal Code*: ");
        profile.setPostalCode(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getPostalCode();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
