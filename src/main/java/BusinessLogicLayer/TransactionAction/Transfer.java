package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;

import java.util.ArrayList;

public class Transfer extends Action {
    private static final String menuLabel = "Transfer";
    private int originAccountPreviousBalance;
    private int targetAccountPreviousBalance;
    private int transferAmount;
    private int originAccountFinalBalance;
    private int targetAccountFinalBalance;
    private int originOutput;
    private int targetOutput;
    private String originTransactionType = "T-Dr";
    private String targetTransactionType = "T-Cr";
    private String targetAccountNumber;
    private boolean verifyTargetAccountNumber;
    private IAccountOperationDatabase accountOperationDatabase;

    public Transfer() {
        IOperationDatabaseFactory operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
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

        String originAccountNumber = loggedInUserContext.getAccountNumber();

        userInterface.displayMessage("Transfer");

        ArrayList<TransactionModel> saveTransactionInModel = new ArrayList<>();
        originAccountPreviousBalance = accountOperationDatabase.getBalance(originAccountNumber);
        userInterface.displayMessage("Current Balance:" + originAccountPreviousBalance);
        transferAmount = Integer.parseInt(userInterface.getMandatoryIntegerUserInput("Please enter Transfer amount: "));

        if (transferAmount > originAccountPreviousBalance) {
            while (transferAmount > originAccountPreviousBalance) {
                userInterface.displayMessage("You can not Transfer more than your balance!");
                transferAmount = Integer.parseInt(userInterface.getUserInputInMultipleOfTen("Please enter Withdraw amount (only in multiple of 10): "));
            }
        }

        targetAccountNumber = userInterface.getMandatoryUserInput("Enter Target Bank Account number: ");
        verifyTargetAccountNumber = accountOperationDatabase.verifyAccountNumber(targetAccountNumber);

        if (!verifyTargetAccountNumber) {
            userInterface.displayMessage("Target account not found!");
            userInterface.insertEmptyLine();
            userInterface.insertEmptyLine();
            return;
        }
        targetAccountPreviousBalance = accountOperationDatabase.getBalance(targetAccountNumber);

        String confirm = userInterface.getConfirmation("Are you sure you want to Transfer " + transferAmount + " to Account Number " + targetAccountNumber + "?");
        if (confirm.equalsIgnoreCase("y")) {
            originAccountFinalBalance = originAccountPreviousBalance - transferAmount;
            targetAccountFinalBalance = targetAccountPreviousBalance + transferAmount;

            originOutput = accountOperationDatabase.updateBalance(originAccountFinalBalance, originAccountNumber);
            targetOutput = accountOperationDatabase.updateBalance(targetAccountFinalBalance, targetAccountNumber);

            if (originOutput == 1 && targetOutput == 1) {
                userInterface.displayMessage("Transfer Success!");
                saveTransactionInModel.add(new TransactionModel(originAccountNumber, originTransactionType, transferAmount, null));
                saveTransactionInModel.add(new TransactionModel(targetAccountNumber, targetTransactionType, transferAmount, null));
//                    accountDatabase.saveTransaction(originAccountNumber, originTransactionType, transferAmount);
//                    accountDatabase.saveTransaction(targetAccountNumber, targetTransactionType, transferAmount);
                accountOperationDatabase.saveTransaction(saveTransactionInModel);
                userInterface.displayMessage("Transaction Successfully registered!");
                userInterface.displayMessage("Updated Balance in your account: " + originAccountFinalBalance);
                userInterface.insertEmptyLine();
                userInterface.insertEmptyLine();
            } else {
                userInterface.displayMessage("Transfer request failed!");
                accountOperationDatabase.updateBalance(originAccountPreviousBalance, originAccountNumber);
                accountOperationDatabase.updateBalance(targetAccountPreviousBalance, targetAccountNumber);
            }
        }

    }
}
