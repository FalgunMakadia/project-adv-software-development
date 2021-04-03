package BusinessLogicLayer.CommonAction;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.PresentationFactory;

public interface IAction {
    void performAction();

    String getMenuLabel();
}
