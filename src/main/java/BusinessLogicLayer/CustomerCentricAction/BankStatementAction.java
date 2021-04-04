package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.TransactionAction.TransactionModel;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;
import PresentationLayer.Pages.IPage;

import java.util.ArrayList;

public class BankStatementAction extends Action {
    private static final String ACTION_TITLE = "Bank Statement";

    private IOperationDatabaseFactory operationDatabaseFactory;
    private IAccountOperationDatabase accountOperationDatabase;
    private IPage bankStatementTable;

    public BankStatementAction() {
        operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        accountOperationDatabase = operationDatabaseFactory.createAccountOperationDatabase();
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
        userInterface.displayMessage(ACTION_TITLE);
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
