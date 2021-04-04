package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;

import java.util.ArrayList;

public class Deposit extends Action {
    private static final String menuLabel = "Deposit";

    private int previousBalance;
    private int hundredBillCount;
    private int fiftyBillCount;
    private int twentyBillCount;
    private int tenBillCount;
    private int totalDepositAmount;
    private int finalBalance;
    private int output;
    private String transactionType = "Cr";
    private IAccountOperationDatabase accountOperationDatabase;

    public Deposit() {
        IOperationDatabaseFactory operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        accountOperationDatabase = operationDatabaseFactory.createAccountOperationDatabase();
    }

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    public void performAction() {
        setCurrentPageInContext();

        String accountNumber = loggedInUserContext.getAccountNumber();

        userInterface.displayMessage("Deposit");
        ArrayList<TransactionModel> saveTransactionInModel = new ArrayList<>();

        previousBalance = accountOperationDatabase.getBalance(accountNumber);
        userInterface.displayMessage("Current Balance:" + previousBalance);

        userInterface.displayMessage("Please enter each bill count that you want to deposit-");
        hundredBillCount = Integer.parseInt(userInterface.getMandatoryIntegerUserInput("100 CAD Bill(s): "));
        fiftyBillCount = Integer.parseInt(userInterface.getMandatoryIntegerUserInput("50 CAD Bill(s): "));
        twentyBillCount = Integer.parseInt(userInterface.getMandatoryIntegerUserInput("20 CAD Bill(s): "));
        tenBillCount = Integer.parseInt(userInterface.getMandatoryIntegerUserInput("10 CAD Bill(s): "));

        totalDepositAmount = (100 * hundredBillCount) + (50 * fiftyBillCount) + (20 * twentyBillCount) + (10 * tenBillCount);
        if (totalDepositAmount == 0) {
            userInterface.displayMessage("You need to at least Deposit 10 CAD!");
            userInterface.insertEmptyLine();
            userInterface.insertEmptyLine();
            return;
        }
        userInterface.displayMessage("Total amount to Deposit:" + totalDepositAmount);

        String confirm = userInterface.getConfirmation("Are you sure you want to Deposit " + totalDepositAmount + " into Account Number " + accountNumber + "?");
        if (confirm.equalsIgnoreCase("y")) {
            finalBalance = previousBalance + totalDepositAmount;

            output = accountOperationDatabase.updateBalance(finalBalance, accountNumber);
            if (output == 1) {
                userInterface.displayMessage("Deposit Success!");
                saveTransactionInModel.add(new TransactionModel(accountNumber, transactionType, totalDepositAmount, null));
//                    accountDatabase.saveTransaction(accountNumber, transactionType, totalDepositAmount);
                accountOperationDatabase.saveTransaction(saveTransactionInModel);
                userInterface.displayMessage("Transaction Successfully registered!");
                userInterface.displayMessage("Updated Balance: " + finalBalance);
                userInterface.insertEmptyLine();
                userInterface.insertEmptyLine();
            } else {
                userInterface.displayMessage("Deposit request failed!");
                accountOperationDatabase.updateBalance(previousBalance, accountNumber);
            }
        }
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }

}
