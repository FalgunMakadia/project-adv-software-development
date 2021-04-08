package PresentationLayer.Pages;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import BusinessLogicLayer.User.UserFactory;

public abstract class AbstractPage implements IAbstractPage {
    protected ILoggedInUserContext loggedInUserContext;
    protected UserFactory userFactory;

    public AbstractPage() {
        loggedInUserContext = userFactory.getLoggedInUserContext();
    }

    public abstract void printPage();
}