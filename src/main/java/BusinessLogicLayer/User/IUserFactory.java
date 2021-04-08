package BusinessLogicLayer.User;

public interface IUserFactory {
    AbstractProfile createCustomerProfile();

    AbstractProfile createBankEmployeeProfile();
}
