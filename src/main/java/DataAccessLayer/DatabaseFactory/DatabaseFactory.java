package DataAccessLayer.DatabaseFactory;

import DataAccessLayer.OperationDatabase.*;
import DataAccessLayer.ProfileDatabase.*;

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
