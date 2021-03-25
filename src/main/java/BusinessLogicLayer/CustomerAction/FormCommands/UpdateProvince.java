package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdateProvince extends FormCommand {
    private final String FIELD_NAME = "Province";
    public UpdateProvince(User user) {
        super(user);
    }

    @Override
    public void execute() {

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
