package DataAccessLayer;

import BusinessLogicLayer.User.ProfileAbstract;

public interface ICustomerDatabase {
    boolean addNewCustomerProfile(ProfileAbstract profile);

    ProfileAbstract getCustomerProfile(String accountNumber);

    boolean updateCustomerProfile(String accountNumber, ProfileAbstract profile);
}
