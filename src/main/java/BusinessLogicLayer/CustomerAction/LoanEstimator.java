package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;

public class LoanEstimator extends Action {
    private static final String menuLabel = "Loan Estimator";
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    @Override
    public void performAction() {
        System.out.println("Loan Estimator");
    }
}
