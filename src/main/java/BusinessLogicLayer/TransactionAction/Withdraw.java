package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.Action;

public class Withdraw extends Action {
    private static final String menuLabel = "Withdraw";
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    @Override
    public void performAction() {
        System.out.println("Withdraw");
    }
}
