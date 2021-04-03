package DataAccessLayer;

import BusinessLogicLayer.User.ProfileAbstract;

import java.sql.SQLException;

public interface ICustomerDatabase {
    boolean add(ProfileAbstract profileAbstract);

    void delete(ProfileAbstract profileAbstract);

    ProfileAbstract getUser(String accountNumber);

    boolean updateUser(String accountNumber, ProfileAbstract profileAbstract);
}
