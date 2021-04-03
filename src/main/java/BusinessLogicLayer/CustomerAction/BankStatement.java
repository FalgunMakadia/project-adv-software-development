package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.TransactionAction.TransactionModel;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IAccountDatabase;
import DataAccessLayer.IDatabaseFactory;
import PresentationLayer.Pages.CustomerCentricPages.IBankStatementTablePage;

import java.util.ArrayList;

public class BankStatement extends Action {
    private static final String menuLabel = "Bank Statement";
    private IAccountDatabase accountDatabase;
    private IDatabaseFactory databaseFactory;
    private IBankStatementTablePage bankStatementTable;

    public BankStatement() {
        databaseFactory = new DatabaseFactory();
        accountDatabase = databaseFactory.createAccountDatabase();
        bankStatementTable = customerCentricPagesFactory.createBankStatementTable();
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
        ArrayList<TransactionModel> transactionList = accountDatabase.getMiniStatement(accountNumber);
        if (0 == transactionList.size()) {
            userInterface.displayMessage("No Transactions are available for this account");
        } else {
            bankStatementTable.printBankStatementTable(transactionList);
        }
    }
}
