package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class ProvinceCommand extends FormCommand {
    private final String FIELD_NAME = "Province";

    public ProvinceCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter Province*: ");
        user.setProvince(userInput);
    }

    @Override
    public String getFieldValue() {
        return user.getProvince();
    }

    @Override
    public String getLabel() {
        return FIELD_NAME;
    }
}
