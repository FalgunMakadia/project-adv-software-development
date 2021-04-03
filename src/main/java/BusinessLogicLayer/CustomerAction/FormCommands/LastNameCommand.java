package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.ProfileAbstract;

public class LastNameCommand extends FormCommand {
    private final String COMMAND_LABEL = "Last Name";

    public LastNameCommand(ProfileAbstract profileAbstract) {
        super(profileAbstract);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Last Name*: ");
        profile.setLastName(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getLastName();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
