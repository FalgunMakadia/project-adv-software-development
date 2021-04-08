package DataAccessLayer.DatabaseFactory;


import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;
import DataAccessLayer.OperationDatabase.OperationDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.ProfileDatabaseFactory;

public class DatabaseFactory implements IDatabaseFactory {
    @Override
    public IProfileDatabaseFactory createProfileDatabaseFactory() {
        return new ProfileDatabaseFactory();
    }

    @Override
    public IOperationDatabaseFactory createOperationDatabaseFactory() {
        return new OperationDatabaseFactory();
    }
}
