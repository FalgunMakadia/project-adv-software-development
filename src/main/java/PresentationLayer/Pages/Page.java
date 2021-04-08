package PresentationLayer.Pages;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;

public abstract class Page implements IPage {
    protected ILoggedInUserContext loggedInUserContext;

    public Page() {
        loggedInUserContext = LoggedInUserContext.instance();
    }

    public abstract void printPage();
}
