package DataAccessLayer.OperationDatabase;

public interface IOperationDatabaseFactory {
    IAccountOperationDatabase createAccountOperationDatabase();

    IWorklistOperationDatabase createWorkListOperationDatabase();
}
