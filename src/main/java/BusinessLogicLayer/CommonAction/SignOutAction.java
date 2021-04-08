package BusinessLogicLayer.CommonAction;

public class SignOutAction extends AbstractAction {
    private static final String ACTION_TITLE = "Sign Out";

    public SignOutAction() {
        super();
    }

    @Override
    public String getActionTitle() {
        return ACTION_TITLE;
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.clearCurrentPage();
    }

    @Override
    public void performAction() {
        setCurrentPageInContext();
        userInterface.displayMessage("Signing Out");
        loggedInUserContext.signOut();
    }
}
