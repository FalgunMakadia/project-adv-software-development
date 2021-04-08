package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.AbstractAction;
import BusinessLogicLayer.TransactionAction.ITransactionModel;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;
import PresentationLayer.Pages.IPage;

import java.util.ArrayList;

public class BankStatementAction extends AbstractAction {
    private static final String ACTION_TITLE = "Bank Statement";
    private ArrayList<ITransactionModel> transactionList;

    private IOperationDatabaseFactory operationDatabaseFactory;
    private IAccountOperationDatabase accountOperationDatabase;
    private IPage bankStatementTable;

    public BankStatementAction() {
        operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        accountOperationDatabase = operationDatabaseFactory.createAccountOperationDatabase();
    }

    public BankStatementAction(IAccountOperationDatabase operationDatabase) {
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
        userInterface.displayMessage(ACTION_TITLE);
        String accountNumber = loggedInUserContext.getAccountNumber();
        transactionList = accountOperationDatabase.getMiniStatement(accountNumber);
        if (0 == transactionList.size()) {
            userInterface.displayMessage("No Transactions are available for this account");
        } else {
            bankStatementTable = customerCentricPagesFactory.createBankStatementTable(transactionList);
            bankStatementTable.printPage();
        }
    }
}
