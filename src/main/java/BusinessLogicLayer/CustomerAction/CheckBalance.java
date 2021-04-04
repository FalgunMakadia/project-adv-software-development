package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;

public class CheckBalance extends Action {
    private static final String menuLabel = "Check Balance";

    private IAccountOperationDatabase accountOperationDatabase;

    public CheckBalance() {
        IOperationDatabaseFactory operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        accountOperationDatabase = operationDatabaseFactory.createAccountOperationDatabase();
    }

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }

    @Override
    public void performAction() {

        setCurrentPageInContext();
        String accountNumber = loggedInUserContext.getAccountNumber();
        String name = loggedInUserContext.getUserName();
        int currentBalance;

        userInterface.displayMessage("Check Balance");

        userInterface.displayMessage("Hello " + name);
        currentBalance = accountOperationDatabase.getBalance(accountNumber);
        userInterface.displayMessage("Current Balance in your account number " + accountNumber + " is: " + currentBalance);
        userInterface.insertEmptyLine();
        userInterface.insertEmptyLine();
    }
}
