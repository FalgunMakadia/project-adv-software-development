package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.TransactionAction.TransactionModel;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;
import PresentationLayer.Pages.IPage;

import java.util.ArrayList;

public class BankStatement extends Action {
    private static final String menuLabel = "Bank Statement";
    private IOperationDatabaseFactory operationDatabaseFactory;
    private IAccountOperationDatabase accountOperationDatabase;
    private IPage bankStatementTable;

    public BankStatement() {
        operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
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
        userInterface.displayMessage("Bank Statement");
        String accountNumber = loggedInUserContext.getAccountNumber();
        ArrayList<TransactionModel> transactionList = accountOperationDatabase.getMiniStatement(accountNumber);
        if (0 == transactionList.size()) {
            userInterface.displayMessage("No Transactions are available for this account");
        } else {
            bankStatementTable = customerCentricPagesFactory.createBankStatementTable(transactionList);
            bankStatementTable.printPage();
        }
    }
}
