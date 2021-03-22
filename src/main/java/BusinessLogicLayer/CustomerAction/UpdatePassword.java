package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;

public class UpdatePassword extends Action {
    private static final String menuLabel = "Update Password";

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    @Override
    public void performAction() {
        setCurrentPageInContext();
        System.out.println("Update Password");
    }
    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }
}
