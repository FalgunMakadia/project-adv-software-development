package DataAccessLayer.DatabaseFactory;

import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;

public interface IDatabaseFactory {
    IProfileDatabaseFactory createProfileDatabaseFactory();

    IOperationDatabaseFactory createOperationDatabaseFactory();
}
