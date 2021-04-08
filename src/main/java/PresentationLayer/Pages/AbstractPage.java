package PresentationLayer.Pages;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;

public abstract class AbstractPage implements IAbstractPage {
    protected ILoggedInUserContext loggedInUserContext;

    public AbstractPage() {
        loggedInUserContext = LoggedInUserContext.instance();
    }

    public abstract void printPage();
}