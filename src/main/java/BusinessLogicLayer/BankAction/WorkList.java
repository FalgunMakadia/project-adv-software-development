package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.Action;

public class WorkList extends Action {
    private static final String menuLabel = "WorkList";

    public WorkList() {
        setCurrentPageInContext();
    }

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
        System.out.println("WorkList");
    }
}
