package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;

public class BankStatement extends Action {
    private static final String menuLabel = "Bank Statement";

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
        System.out.println("Bank Statement");
    }
}
