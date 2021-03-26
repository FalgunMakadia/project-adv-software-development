package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class SSNNumberCommand extends FormCommand {
    private final String FIELD_LABEL = "SSN Number";
    public SSNNumberCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
        userInterface.displayMessage("Your SSN Number is: " + user.getSsnNo());
        String userInput = userInterface.getMandatoryUserInput("Enter SSN*: ");
        user.setSsnNo(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getSsnNo();
    }

    @Override
    public String getLabel() {
        return FIELD_LABEL;
    }
}
