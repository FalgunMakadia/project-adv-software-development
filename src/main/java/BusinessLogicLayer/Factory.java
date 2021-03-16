package BusinessLogicLayer;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CommonAction.ILogin;
import BusinessLogicLayer.User.User;

public abstract class Factory {
    public abstract Action createNewOpenNewAccount();
    public abstract ILogin createLogin();
    public abstract User createCustomer();
}
