package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.AbstractFormCommand;
import BusinessLogicLayer.User.ILoggedInUserContext;

public class BackToMainMenuProfileFormActionCommand extends AbstractFormCommand {
    private static final String COMMAND_LABEL = "Back to Main Menu";
    private static final String COMMAND_TYPE = "ACTION";

    ILoggedInUserContext loggedInUserContext;

    public BackToMainMenuProfileFormActionCommand() {
        super();
        loggedInUserContext = userFactory.getLoggedInUserContext();
    }

    @Override
    public void execute() {
        loggedInUserContext.setCurrentPage("");
    }

    @Override
    public String getFieldValue() {
        return COMMAND_TYPE;
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }
}
