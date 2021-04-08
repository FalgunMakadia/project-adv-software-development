package DataAccessLayer.DatabaseFactory;

import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IEmployeeProfileDatabase;
import DataAccessLayer.OperationDatabase.IWorklistOperationDatabase;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.ProfileDatabase.ICustomerProfileDatabase;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;

public interface IDatabaseFactory {
    IProfileDatabaseFactory createProfileDatabaseFactory();

    IOperationDatabaseFactory createOperationDatabaseFactory();
}
