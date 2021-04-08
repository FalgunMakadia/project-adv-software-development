package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;

public class CheckBalanceAction extends Action {
    private static final String ACTION_TITLE = "Check Balance";

    private IAccountOperationDatabase accountOperationDatabase;

    public CheckBalanceAction() {
        IOperationDatabaseFactory operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        accountOperationDatabase = operationDatabaseFactory.createAccountOperationDatabase();
    }

    public CheckBalanceAction(IAccountOperationDatabase operationDatabase) {
        accountOperationDatabase = operationDatabase;
    }

    @Override
    public String getActionTitle() {
        return ACTION_TITLE;
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(ACTION_TITLE);
    }

    @Override
    public void performAction() {
        setCurrentPageInContext();
        String accountNumber = loggedInUserContext.getAccountNumber();
        String name = loggedInUserContext.getUserName();
        int currentBalance;

        userInterface.displayMessage(ACTION_TITLE);

        userInterface.displayMessage("Hello " + name);
        currentBalance = accountOperationDatabase.getBalance(accountNumber);
        userInterface.displayMessage("Current Balance in your account number " + accountNumber + " is: " + currentBalance);
        userInterface.insertEmptyLine();
        userInterface.insertEmptyLine();
    }
}
