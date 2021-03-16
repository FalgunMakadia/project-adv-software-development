package PresentationLayer;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;

import java.security.PublicKey;

public abstract class Page {
    protected ILoggedInUserContext loggedInUserContext;
    public Page(){
        loggedInUserContext = LoggedInUserContext.getInstance();
    }
    public  abstract void printMenu();
    }
