package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;

public class BackToMainMenuProfileFormActionCommand extends FormCommand {
    ILoggedInUserContext loggedInUserContext;
    String menuLabel;

    public BackToMainMenuProfileFormActionCommand(String menuLabel) {
        loggedInUserContext = LoggedInUserContext.instance();
        this.menuLabel = menuLabel;
    }

    @Override
    public void execute() {
        loggedInUserContext.setCurrentPage("");
    }

    @Override
    public String getFieldValue() {
        return null;
    }

    @Override
    public String getCommandLabel() {
        return menuLabel;
    }
}
