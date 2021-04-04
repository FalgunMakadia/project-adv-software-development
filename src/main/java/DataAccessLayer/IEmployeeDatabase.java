package DataAccessLayer;

import BusinessLogicLayer.User.ProfileAbstract;

public interface IEmployeeDatabase {
    int addNewBankEmployeeProfile(ProfileAbstract bankEmployeeProfile);
}
