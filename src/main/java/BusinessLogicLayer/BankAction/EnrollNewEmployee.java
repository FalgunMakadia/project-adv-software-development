package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.Action;

public class EnrollNewEmployee extends Action {
    private static final String menuLabel = "WorkList";

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage("BankStatement");
    }

    @Override
    public void performAction() {
        setCurrentPageInContext();
        System.out.println("Enroll New Employee");
    }
}
