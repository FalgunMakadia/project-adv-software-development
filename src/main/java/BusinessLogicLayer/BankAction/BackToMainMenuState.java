package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;

public class BackToMainMenuState extends FormState {
    ILoggedInUserContext loggedInUserContext;
    String menuLabel;

    public BackToMainMenuState(String menuLabel) {
        loggedInUserContext = LoggedInUserContext.instance();
        this.menuLabel = menuLabel;
    }

    @Override
    public void performStateTask() {
        loggedInUserContext.setCurrentPage("");
    }

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
}
