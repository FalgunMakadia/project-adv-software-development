package BusinessLogicLayer.Transaction;

import BusinessLogicLayer.CommonAction.Action;

public class Transfer extends Action {
    @Override
    public void performAction() {
        System.out.println("Transfer");
    }
}
