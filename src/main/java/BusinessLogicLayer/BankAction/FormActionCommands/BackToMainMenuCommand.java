package BusinessLogicLayer.BankAction.FormActionCommands;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;

public class BackToMainMenuCommand extends FormCommand {
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
    public String getFieldValue() {
        return null;
    }

    @Override
    public String getCommandLabel() {
        return menuLabel;
    }
}
