package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IAccountDatabase;
import DataAccessLayer.IDatabaseFactory;

import java.util.ArrayList;

public class Transfer extends Action {
    private static final String menuLabel = "Transfer";
    int originAccountPreviousBalance;
    int targetAccountPreviousBalance;
    int transferAmount;
    int originAccountFinalBalance;
    int targetAccountFinalBalance;
    int originOutput;
    int targetOutput;
    String originTransactionType = "T-Dr";
    String targetTransactionType = "T-Cr";
    String targetAccountNumber;
    boolean verifyTargetAccountNumber;

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

        String originAccountNumber = loggedInUserContext.getAccountNumber();

        userInterface.displayMessage("Transfer");
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        IAccountDatabase accountDatabase = databaseFactory.createAccountDatabase();
        ArrayList<TransactionModel> saveTransactionInModel = new ArrayList<>();
        originAccountPreviousBalance = accountDatabase.getUserBalance(originAccountNumber);
        userInterface.displayMessage("Current Balance:" + originAccountPreviousBalance);
        transferAmount = Integer.parseInt(userInterface.getMandatoryIntegerUserInput("Please enter Transfer amount: "));

        if (transferAmount > originAccountPreviousBalance) {
            while (transferAmount > originAccountPreviousBalance) {
                userInterface.displayMessage("You can not Transfer more than your balance!");
                transferAmount = Integer.parseInt(userInterface.getUserInputInMultipleOfTen("Please enter Withdraw amount (only in multiple of 10): "));
            }
        }

        targetAccountNumber = userInterface.getMandatoryUserInput("Enter Target Bank Account number: ");
        verifyTargetAccountNumber = accountDatabase.verifyAccountNumber(targetAccountNumber);

        if (!verifyTargetAccountNumber) {
            userInterface.displayMessage("Target account not found!");
            userInterface.insertEmptyLine();
            userInterface.insertEmptyLine();
            return;
        }
        targetAccountPreviousBalance = accountDatabase.getUserBalance(targetAccountNumber);

        String confirm = userInterface.getConfirmation("Are you sure you want to Transfer " + transferAmount + " to Account Number " + targetAccountNumber + "?");
        if (confirm.equalsIgnoreCase("y")) {
            originAccountFinalBalance = originAccountPreviousBalance - transferAmount;
            targetAccountFinalBalance = targetAccountPreviousBalance + transferAmount;

            originOutput = accountDatabase.updateBalance(originAccountFinalBalance, originAccountNumber);
            targetOutput = accountDatabase.updateBalance(targetAccountFinalBalance, targetAccountNumber);

            if (originOutput == 1 && targetOutput == 1) {
                userInterface.displayMessage("Transfer Success!");
                saveTransactionInModel.add(new TransactionModel(originAccountNumber, originTransactionType, transferAmount, null));
                saveTransactionInModel.add(new TransactionModel(targetAccountNumber, targetTransactionType, transferAmount, null));
//                    accountDatabase.saveTransaction(originAccountNumber, originTransactionType, transferAmount);
//                    accountDatabase.saveTransaction(targetAccountNumber, targetTransactionType, transferAmount);
                accountDatabase.saveTransaction(saveTransactionInModel);
                userInterface.displayMessage("Transaction Successfully registered!");
                userInterface.displayMessage("Updated Balance in your account: " + originAccountFinalBalance);
                userInterface.insertEmptyLine();
                userInterface.insertEmptyLine();
            } else {
                userInterface.displayMessage("Transfer request failed!");
                accountDatabase.updateBalance(originAccountPreviousBalance, originAccountNumber);
                accountDatabase.updateBalance(targetAccountPreviousBalance, targetAccountNumber);
            }
        }

    }
}
