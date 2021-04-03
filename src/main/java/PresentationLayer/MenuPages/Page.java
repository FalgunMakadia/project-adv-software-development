package PresentationLayer.MenuPages;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;

public abstract class Page implements IPage {
    protected ILoggedInUserContext loggedInUserContext;

    public Page() {
        loggedInUserContext = LoggedInUserContext.instance();
    }

    public abstract void printMenu();
}
