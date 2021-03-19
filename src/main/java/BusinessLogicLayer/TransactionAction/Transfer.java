package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.Action;

public class Transfer extends Action {
    private static final String menuLabel = "Transfer";
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    @Override
    public void performAction() {
        System.out.println("Transfer");
    }
}
