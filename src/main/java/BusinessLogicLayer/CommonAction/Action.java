package BusinessLogicLayer.CommonAction;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.PresentationFactory;

public abstract class Action {
    protected IUserInterface userInterface = null;
    protected ILoggedInUserContext loggedInUserContext;
    public Action(){
        IPresentationFactory presentationFactory = new PresentationFactory();
        userInterface = presentationFactory.createUserInterface();
        loggedInUserContext = LoggedInUserContext.instance();
    }
    public abstract void performAction();
    public abstract String getMenuLabel();
}
