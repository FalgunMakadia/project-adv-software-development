package BusinessLogicLayer.CommonAction;

public class SignOut extends Action {
    public SignOut(){
        super();
    }
    @Override
    public void performAction() {
        System.out.println("Signing Out");
        loggedInUserContext.setUserName(null);
        loggedInUserContext.setUserRole(null);
        loggedInUserContext.setAccountNumber(null);
        loggedInUserContext.setActiveStatus(false);
        loggedInUserContext.setLoginStatus(false);

    }
}
