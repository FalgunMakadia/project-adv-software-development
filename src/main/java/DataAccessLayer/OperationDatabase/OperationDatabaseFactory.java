package DataAccessLayer.OperationDatabase;

public class OperationDatabaseFactory implements IOperationDatabaseFactory {
    @Override
    public IAccountOperationDatabase createAccountOperationDatabase() {
        return new AccountOperationDatabase();
    }

    @Override
    public IWorklistOperationDatabase createWorkListOperationDatabase() {
        return new WorklistOperationDatabase();
    }
}
