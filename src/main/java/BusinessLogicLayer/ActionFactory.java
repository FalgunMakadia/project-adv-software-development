package BusinessLogicLayer;

import BusinessLogicLayer.BankAction.ExistingBankAccount;
import BusinessLogicLayer.BankAction.OpenNewAccount;
import BusinessLogicLayer.BankAction.WorkList;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CommonAction.ILogin;
import BusinessLogicLayer.CommonAction.Login;
import BusinessLogicLayer.CommonAction.SignOut;
import BusinessLogicLayer.User.Customer;
import BusinessLogicLayer.User.User;

public class ActionFactory implements IActionFactory {
    @Override
    public Action createNewOpenNewAccount() {
        return new OpenNewAccount();
    }

    @Override
    public Action createExistingBankAccount() {
        return new ExistingBankAccount();
    }

    @Override
    public Action createWorkList() {
        return new WorkList();
    }

    @Override
    public Action createSignOut() {
        return new SignOut();
    }

    @Override
    public ILogin createLogin() {
        return new Login();
    }

    @Override
    public User createCustomer() {
        return new Customer();
    }
}
