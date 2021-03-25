package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdateAddressLine1 extends FormCommand {
    private final String FIELD_LABEL = "Address Line 1";
    public UpdateAddressLine1(User user) {
        super(user);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getFieldValue() {
        return user.getAddressLine1();
    }

    @Override
    public String getLabel() {
        return FIELD_LABEL;
    }
}
