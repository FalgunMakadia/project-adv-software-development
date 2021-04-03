package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.ProfileAbstract;

public class MiddleNameCommand extends FormCommand {
    private final String COMMAND_LABEL = "Middle Name";

    public MiddleNameCommand(ProfileAbstract profileAbstract) {
        super(profileAbstract);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getUserInput("Enter Middle Name: ");
        profile.setMiddleName(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getMiddleName();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
