package PresentationLayer;

import BusinessLogicLayer.BankEmployee.OpenNewAccount;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CustomerAction.UpdatePersonalDetails;

public class ActionFactory extends Factory{
    @Override
    public Action createNewOpenNewAccount(){
        return new OpenNewAccount();
    }

    @Override
    public Action updatePersonalDetails() {
        return new UpdatePersonalDetails();
    }
}
