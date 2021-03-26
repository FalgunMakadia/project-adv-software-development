package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class DOBCommand extends FormCommand {
    private final String FIELD_LABEL = "Date Of Birth";
    public DOBCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
        userInterface.displayMessage("Your Date Of Birth is: " + user.getDateOfBirth());
        String userInput = userInterface.getMandatoryUserInput("Enter DOB(DD/MM/YYYY)*: ");
        user.setDateOfBirth(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getDateOfBirth();
    }

    @Override
    public String getLabel() {
        return FIELD_LABEL;
    }
}
