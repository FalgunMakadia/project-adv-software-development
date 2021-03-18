package PresentationLayer;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;

public abstract class Page {
    protected ILoggedInUserContext loggedInUserContext;
    public Page(){
        loggedInUserContext = LoggedInUserContext.instance();
    }
    public  abstract void printMenu();
    }