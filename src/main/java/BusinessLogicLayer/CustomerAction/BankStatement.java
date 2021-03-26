package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.TransactionAction.TransactionModel;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IAccountDatabase;
import DataAccessLayer.IDatabaseFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class BankStatement extends Action {
    private static final String menuLabel = "Bank Statement";
    private IAccountDatabase accountDatabase;
    private IDatabaseFactory databaseFactory;

    public BankStatement() {
        databaseFactory = new DatabaseFactory();
        accountDatabase = databaseFactory.createAccountDatabase();
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
        System.out.println("Bank Statement");
        String accountNumber = loggedInUserContext.getAccountNumber();
        try {
            ArrayList<TransactionModel> transactionList = accountDatabase.getMiniStatement(accountNumber);
            if (0 == transactionList.size()) {
                userInterface.displayMessage("No Transactions are available for this account");
            } else {
                for (TransactionModel transaction : transactionList) {
                    userInterface.displayMessage("TransactionType: " + transaction.getTransactionType()
                            + " Amount: " + transaction.getAmount()
                            + " Date: " + transaction.getDate());
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
