package PresentationLayer;

import BusinessLogicLayer.BankEmployee.OpenNewAccount;
import BusinessLogicLayer.CommonAction.Action;

public class ActionFactory extends Factory{
    @Override
    public Action createNewOpenNewAccount(){
        return new OpenNewAccount();
    }
}
