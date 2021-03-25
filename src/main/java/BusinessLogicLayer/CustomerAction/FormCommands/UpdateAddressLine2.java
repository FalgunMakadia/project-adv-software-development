package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdateAddressLine2 extends FormCommand {
    private final String FIELD_LABEL = "Address Line 2";
    public UpdateAddressLine2(User user) {
        super(user);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getFieldValue() {
        return user.getAddressLine2();
    }

    @Override
    public String getLabel() {
        return FIELD_LABEL;
    }
}
