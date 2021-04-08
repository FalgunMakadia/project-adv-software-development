package BusinessLogicLayer.User;

public class UserFactory implements IUserFactory{
    @Override
    public AbstractProfile createCustomerProfile() {
        return new CustomerProfile();
    }

    @Override
    public AbstractProfile createBankEmployeeProfile() {
        return new BankEmployeeProfile();
    }
}
