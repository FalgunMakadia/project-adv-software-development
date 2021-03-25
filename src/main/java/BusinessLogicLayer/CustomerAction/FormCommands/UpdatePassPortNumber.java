package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdatePassPortNumber extends FormCommand {
    private final String FIELD_LABEL = "Passport Number";
    public UpdatePassPortNumber(User user) {
        super(user);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getFieldValue() {
        return user.getPassport();
    }

    @Override
    public String getLabel() {
        return FIELD_LABEL;
    }
}
