package BusinessLogicLayer;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CommonAction.ILogin;
import BusinessLogicLayer.User.User;

public interface IActionFactory {
    Action createNewOpenNewAccount();
    Action createExistingBankAccount();
    Action createWorkList();
    Action createSignOut();
    ILogin createLogin();

    User createCustomer();

}
