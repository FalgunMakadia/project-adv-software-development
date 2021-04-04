package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IAccountDatabase;
import DataAccessLayer.IDatabaseFactory;

import java.util.ArrayList;

public class Withdraw extends Action {
    private static final String menuLabel = "Withdraw";
    int previousBalance;
    int withdrawAmount;
    int finalBalance;
    int output;
    String transactionType = "Dr";

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
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        IAccountDatabase accountDatabase = databaseFactory.createAccountDatabase();
        ArrayList<TransactionModel> saveTransactionInModel = new ArrayList<>();
        previousBalance = accountDatabase.getBalance(accountNumber);
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

            output = accountDatabase.updateBalance(finalBalance, accountNumber);
            if (output == 1) {
                userInterface.displayMessage("Withdraw Success!");
                saveTransactionInModel.add(new TransactionModel(accountNumber, transactionType, withdrawAmount, null));
//                    accountDatabase.saveTransaction(accountNumber, transactionType, withdrawAmount);
                accountDatabase.saveTransaction(saveTransactionInModel);
                userInterface.displayMessage("Transaction Successfully registered!");
                userInterface.displayMessage("Updated Balance: " + finalBalance);
                userInterface.insertEmptyLine();
                userInterface.insertEmptyLine();
            } else {
                userInterface.displayMessage("Withdraw request failed!");
                accountDatabase.updateBalance(previousBalance, accountNumber);
            }
        }

    }
}
