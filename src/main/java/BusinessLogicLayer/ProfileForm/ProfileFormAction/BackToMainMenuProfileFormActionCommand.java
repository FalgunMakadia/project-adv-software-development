package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;

public class BackToMainMenuProfileFormActionCommand extends FormCommand {
    private static final String COMMAND_LABEL = "Back to Main Menu";
    private static final String COMMAND_TYPE = "ACTION";

    ILoggedInUserContext loggedInUserContext;

    public BackToMainMenuProfileFormActionCommand() {
        loggedInUserContext = LoggedInUserContext.instance();
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
