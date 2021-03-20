package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;

public class CheckBalance extends Action {
    private static final String menuLabel = "Check Balance";
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }
    @Override
    public void performAction() {
        setCurrentPageInContext();
        System.out.println("CheckBalance");
    }
}
