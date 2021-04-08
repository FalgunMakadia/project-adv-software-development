package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.AbstractAction;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;

import java.util.ArrayList;

public class WithdrawAction extends AbstractAction {
    private static final String ACTION_TITLE = "Withdraw";
    private static final String TRANSACTION_TYPE = "Dr";
    private static final String YES = "y";
    private int previousBalance;
    private int withdrawAmount;
    private int finalBalance;
    private int output;
    private IOperationDatabaseFactory operationDatabaseFactory;
    private IAccountOperationDatabase accountOperationDatabase;

    public WithdrawAction() {
        operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        accountOperationDatabase = operationDatabaseFactory.createAccountOperationDatabase();
    }

    public WithdrawAction(IAccountOperationDatabase operationDatabase) {
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

        String accountNumber = loggedInUserContext.getAccountNumber();

        userInterface.displayMessage(ACTION_TITLE);

        ArrayList<ITransactionModel> saveTransactionInModel = new ArrayList<>();
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
        if (confirm.equalsIgnoreCase(YES)) {
            finalBalance = previousBalance - withdrawAmount;

            output = accountOperationDatabase.updateBalance(finalBalance, accountNumber);
            if (output == 1) {
                userInterface.displayMessage("Withdraw Success!");
                saveTransactionInModel.add(new TransactionModel(accountNumber, TRANSACTION_TYPE, withdrawAmount, null));
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
