package DataAccessLayer.ProfileDatabase;

import BusinessLogicLayer.User.AbstractProfile;

public interface IEmployeeProfileDatabase {
    int addNewBankEmployeeProfile(AbstractProfile bankEmployeeProfile);
}
