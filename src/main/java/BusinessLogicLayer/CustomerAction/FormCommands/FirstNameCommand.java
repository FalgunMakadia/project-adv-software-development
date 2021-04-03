package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.ProfileAbstract;

public class FirstNameCommand extends FormCommand {
    private final String COMMAND_LABEL = "First Name";

    public FirstNameCommand(ProfileAbstract profileAbstract) {
        super(profileAbstract);
    }

    public FirstNameCommand() {
        super();
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter First Name*: ");
        profile.setFirstName(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getFirstName();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }

}
