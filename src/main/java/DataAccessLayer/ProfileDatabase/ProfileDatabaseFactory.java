package DataAccessLayer.ProfileDatabase;

public class ProfileDatabaseFactory implements IProfileDatabaseFactory{
    @Override
    public ICustomerProfileDatabase createCustomerProfileDatabase() {
        return new CustomerProfileDatabase();
    }

    @Override
    public IEmployeeProfileDatabase createEmployeeProfileDatabase() {
        return new EmployeeProfileDatabase();
    }

    @Override
    public IUserProfileDatabase createUserProfileDatabase() {
        return new UserProfileDatabase();
    }
}
