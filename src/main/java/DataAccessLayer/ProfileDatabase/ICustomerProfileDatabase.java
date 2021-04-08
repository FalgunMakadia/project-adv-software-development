package DataAccessLayer.ProfileDatabase;

import BusinessLogicLayer.User.AbstractProfile;

public interface ICustomerProfileDatabase {
    boolean addNewCustomerProfile(AbstractProfile profile);

    AbstractProfile getCustomerProfile(String accountNumber);

    boolean updateCustomerProfile(String accountNumber, AbstractProfile profile);
}
