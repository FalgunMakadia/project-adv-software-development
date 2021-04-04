package DataAccessLayer.ProfileDatabase;

import BusinessLogicLayer.User.ProfileAbstract;

public interface ICustomerProfileDatabase {
    boolean addNewCustomerProfile(ProfileAbstract profile);

    ProfileAbstract getCustomerProfile(String accountNumber);

    boolean updateCustomerProfile(String accountNumber, ProfileAbstract profile);
}
