package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;

public class CheckBalance extends Action {
    private static final String menuLabel = "Check Balance";
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    @Override
    public void performAction() {
        System.out.println("Check Balance");
    }
}
