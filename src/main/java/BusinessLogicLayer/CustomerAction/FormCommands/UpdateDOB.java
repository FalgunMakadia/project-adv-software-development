package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

public class UpdateDOB extends FormCommand {
    private final String FIELD_LABEL = "Date Of Birth";
    public UpdateDOB(User user) {
        super(user);
    }

    @Override
    public void execute() {

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
