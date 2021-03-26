package BusinessLogicLayer.BankAction.FormActionCommands;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;

public class BackToMainMenuCommand extends FormActionCommand {
    ILoggedInUserContext loggedInUserContext;
    String menuLabel;

    public BackToMainMenuCommand(String menuLabel) {
        loggedInUserContext = LoggedInUserContext.instance();
        this.menuLabel = menuLabel;
    }

    @Override
    public void execute() {
        loggedInUserContext.setCurrentPage("");
    }

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
}
