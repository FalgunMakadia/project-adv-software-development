package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.ProfileAbstract;

public class ContactCommand extends FormCommand {
    private final String COMMAND_LABEL = "Contact";

    public ContactCommand(ProfileAbstract profileAbstract) {
        super(profileAbstract);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryLongUserInputWithMinimumRange("Enter Contact Number*: ", 10);
        profile.setContact(userInput);
    }

    @Override
    public String getFieldValue() {
        return profile.getContact();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }

}
