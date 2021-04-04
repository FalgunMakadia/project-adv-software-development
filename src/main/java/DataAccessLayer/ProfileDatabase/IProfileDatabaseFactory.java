package DataAccessLayer.ProfileDatabase;

public interface IProfileDatabaseFactory {
    ICustomerProfileDatabase createCustomerProfileDatabase();

    IEmployeeProfileDatabase createEmployeeProfileDatabase();

    IUserProfileDatabase createUserProfileDatabase();
}
