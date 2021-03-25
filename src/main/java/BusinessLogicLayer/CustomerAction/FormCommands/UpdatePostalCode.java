package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdatePostalCode extends FormCommand {
    private final String FIELD_LABEL = "Postal Code";
    public UpdatePostalCode(User user) {
        super(user);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getFieldValue() {
        return user.getPostalCode();
    }

    @Override
    public String getLabel() {
        return FIELD_LABEL;
    }
}
