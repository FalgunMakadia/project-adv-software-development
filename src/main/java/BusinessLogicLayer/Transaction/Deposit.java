package BusinessLogicLayer.Transaction;

import BusinessLogicLayer.CommonAction.Action;

public class Deposit extends Action {

    @Override
    public void performAction() {
        System.out.println("Deposit");
    }
}
