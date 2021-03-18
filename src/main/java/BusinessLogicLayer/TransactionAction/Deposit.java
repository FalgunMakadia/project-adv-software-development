package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.Action;

public class Deposit extends Action {
    private static final String menuLabel = "Deposit";
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    @Override
    public void performAction() {
        System.out.println("Deposit");
    }
}
