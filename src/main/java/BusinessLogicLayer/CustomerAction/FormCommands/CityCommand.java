package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class CityCommand extends FormCommand {
    private final String COMMAND_LABEL = "City";

    public CityCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter New City*: ");
        user.setCity(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getCity();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
