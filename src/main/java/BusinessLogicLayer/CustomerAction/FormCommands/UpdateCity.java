package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdateCity extends FormCommand {
    private final String FIELD_LABEL = "City";
    public UpdateCity(User user) {
        super(user);
    }

    @Override
    public void execute() {
        userInterface.displayMessage("Your City is: " + user.getCity());
        String userInput = userInterface.getMandatoryUserInput("Enter New City*: ");
        user.setCity(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getCity();
    }

    @Override
    public String getLabel() {
        return FIELD_LABEL;
    }
}
