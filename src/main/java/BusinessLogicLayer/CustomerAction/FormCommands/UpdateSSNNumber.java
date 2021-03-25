package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdateSSNNumber extends FormCommand {
    private final String FIELD_LABEL = "SSN Number";
    public UpdateSSNNumber(User user) {
        super(user);
    }

    @Override
    public void execute() {

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
