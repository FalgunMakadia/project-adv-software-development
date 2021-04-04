package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;

import java.util.ArrayList;

public class Withdraw extends Action {
    private static final String menuLabel = "Withdraw";
    private int previousBalance;
    private int withdrawAmount;
    private int finalBalance;
    private int output;
    private String transactionType = "Dr";
    private IOperationDatabaseFactory operationDatabaseFactory;
    private IAccountOperationDatabase accountOperationDatabase;

    public Withdraw() {
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

        String accountNumber = loggedInUserContext.getAccountNumber();

        userInterface.displayMessage("Withdraw");

        ArrayList<TransactionModel> saveTransactionInModel = new ArrayList<>();
        previousBalance = accountOperationDatabase.getBalance(accountNumber);
        userInterface.displayMessage("Current Balance:" + previousBalance);
        withdrawAmount = Integer.parseInt(userInterface.getUserInputInMultipleOfTen("Please enter Withdraw amount (only in multiple of 10): "));

        if (withdrawAmount > previousBalance) {
            while (withdrawAmount > previousBalance) {
                userInterface.displayMessage("You can not Withdraw more than your balance!");
                withdrawAmount = Integer.parseInt(userInterface.getUserInputInMultipleOfTen("Please enter Withdraw amount (only in multiple of 10): "));
            }
        }

        String confirm = userInterface.getConfirmation("Are you sure you want to Withdraw " + withdrawAmount + " from Account Number " + accountNumber + "?");
        if (confirm.equalsIgnoreCase("y")) {
            finalBalance = previousBalance - withdrawAmount;

            output = accountOperationDatabase.updateBalance(finalBalance, accountNumber);
            if (output == 1) {
                userInterface.displayMessage("Withdraw Success!");
                saveTransactionInModel.add(new TransactionModel(accountNumber, transactionType, withdrawAmount, null));
//                    accountDatabase.saveTransaction(accountNumber, transactionType, withdrawAmount);
                accountOperationDatabase.saveTransaction(saveTransactionInModel);
                userInterface.displayMessage("Transaction Successfully registered!");
                userInterface.displayMessage("Updated Balance: " + finalBalance);
                userInterface.insertEmptyLine();
                userInterface.insertEmptyLine();
            } else {
                userInterface.displayMessage("Withdraw request failed!");
                accountOperationDatabase.updateBalance(previousBalance, accountNumber);
            }
        }

    }
}
