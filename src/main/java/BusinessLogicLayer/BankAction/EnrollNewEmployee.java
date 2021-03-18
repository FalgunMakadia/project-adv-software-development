package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.Action;

public class EnrollNewEmployee extends Action {
    private static final String menuLabel = "WorkList";
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    public void performAction() {
        System.out.println("Enroll New Employee");
    }
}
