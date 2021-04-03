package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IAccountDatabase;
import DataAccessLayer.IDatabaseFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class Deposit extends Action {
    private static final String menuLabel = "Deposit";
    int previousBalance;
    int hundredBillCount;
    int fiftyBillCount;
    int twentyBillCount;
    int tenBillCount;
    int totalDepositAmount;
    int finalBalance;
    int output;
    String transactionType = "Cr";

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    public void performAction() {
        setCurrentPageInContext();

        String accountNumber = loggedInUserContext.getAccountNumber();

        userInterface.displayMessage("Deposit");
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        IAccountDatabase accountDatabase = databaseFactory.createAccountDatabase();
        ArrayList<TransactionModel> saveTransactionInModel = new ArrayList<>();

        previousBalance = accountDatabase.getUserBalance(accountNumber);
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

            output = accountDatabase.updateBalance(finalBalance, accountNumber);
            if (output == 1) {
                userInterface.displayMessage("Deposit Success!");
                saveTransactionInModel.add(new TransactionModel(accountNumber, transactionType, totalDepositAmount, null));
//                    accountDatabase.saveTransaction(accountNumber, transactionType, totalDepositAmount);
                accountDatabase.saveTransaction(saveTransactionInModel);
                userInterface.displayMessage("Transaction Successfully registered!");
                userInterface.displayMessage("Updated Balance: " + finalBalance);
                userInterface.insertEmptyLine();
                userInterface.insertEmptyLine();
            } else {
                userInterface.displayMessage("Deposit request failed!");
                accountDatabase.updateBalance(previousBalance, accountNumber);
            }
        }
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }

}
