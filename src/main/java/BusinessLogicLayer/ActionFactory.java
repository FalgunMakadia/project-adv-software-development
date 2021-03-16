package BusinessLogicLayer;

import BusinessLogicLayer.BankEmployee.OpenNewAccount;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CommonAction.ILogin;
import BusinessLogicLayer.CommonAction.Login;
import BusinessLogicLayer.User.Customer;
import BusinessLogicLayer.User.User;

public class ActionFactory extends Factory {
    @Override
    public Action createNewOpenNewAccount() {
        return new OpenNewAccount();
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
