package PresentationLayer.UserPages;

import PresentationLayer.Page;

public class SignOut extends Page {
    public SignOut(){
        super();
    }
    @Override
    public void printMenu() {
        System.out.println("Signing Out");
        loggedInUserContext.setUserName(null);
        loggedInUserContext.setUserRole(null);
        loggedInUserContext.setAccountNumber(null);
        loggedInUserContext.setActiveStatus(false);
        loggedInUserContext.setLoginStatus(false);

    }
}
