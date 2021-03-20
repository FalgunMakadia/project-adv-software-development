package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.Action;

public class Transfer extends Action {
    private static final String menuLabel = "Transfer";

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
        System.out.println("Transfer");
    }
}
