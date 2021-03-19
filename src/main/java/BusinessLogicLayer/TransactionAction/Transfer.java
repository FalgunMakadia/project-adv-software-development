package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IAccountDatabase;
import DataAccessLayer.IDatabaseFactory;

import java.sql.SQLException;

public class Transfer extends Action {
    private static final String menuLabel = "Transfer";
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    @Override
    public void performAction() {

        int originAccountPreviousBalance;
        int targetAccountPreviousBalance;
        int transferAmount;
        int originAccountFinalBalance;
        int targetAccountFinalBalance;
        int originOutput;
        int targetOutput;
        String originTransactionType = "T-Dr";
        String targetTransactionType = "T-Cr";
        String originAccountNumber = loggedInUserContext.getAccountNumber();
        String targetAccountNumber;
        boolean verifyTargetAccountNumber;

        System.out.println("Transfer");
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        IAccountDatabase accountDatabase = databaseFactory.createAccountDatabase();

        try {
            originAccountPreviousBalance = accountDatabase.getUserBalance(originAccountNumber);
            userInterface.displayMessage("Current Balance:" + originAccountPreviousBalance);
            transferAmount = Integer.parseInt(userInterface.getMandatoryIntegerUserInput("Please enter Transfer amount: "));

            if(transferAmount > originAccountPreviousBalance) {
                while(transferAmount > originAccountPreviousBalance){
                    userInterface.displayMessage("You can not Transfer more than your balance!");
                    transferAmount = Integer.parseInt(userInterface.getUserInputInMultipleOfTen("Please enter Withdraw amount (only in multiple of 10): "));
                }
            }

            targetAccountNumber = userInterface.getMandatoryUserInput("Enter Target Bank Account number: ");
            verifyTargetAccountNumber = accountDatabase.verifyAccountNumber(targetAccountNumber);

            if(!verifyTargetAccountNumber) {
                userInterface.displayMessage("Target account not found!");
                userInterface.insertEmptyLine();
                userInterface.insertEmptyLine();
                return;
            }
            targetAccountPreviousBalance = accountDatabase.getUserBalance(targetAccountNumber);

            String confirm = userInterface.getConfirmation("Are you sure you want to Transfer " + transferAmount + " to Account Number " + targetAccountNumber + "?");
            if(confirm.equalsIgnoreCase("y")){
                originAccountFinalBalance = originAccountPreviousBalance - transferAmount;
                targetAccountFinalBalance = targetAccountPreviousBalance + transferAmount;

                originOutput = accountDatabase.updateBalance(originAccountFinalBalance, originAccountNumber);
                targetOutput = accountDatabase.updateBalance(targetAccountFinalBalance, targetAccountNumber);

                if (originOutput == 1 && targetOutput == 1) {
                    userInterface.displayMessage("Transfer Success!");
                    accountDatabase.saveTransaction(originAccountNumber, originTransactionType, transferAmount);
                    accountDatabase.saveTransaction(targetAccountNumber, targetTransactionType, transferAmount);
                    userInterface.displayMessage("Transaction Successfully registered!");
                    userInterface.displayMessage("Updated Balance in your account: " + originAccountFinalBalance);
                    userInterface.insertEmptyLine();
                    userInterface.insertEmptyLine();
                } else {
                    userInterface.displayMessage("Trasfer request failed!");
                    accountDatabase.updateBalance(originAccountPreviousBalance, originAccountNumber);
                    accountDatabase.updateBalance(targetAccountPreviousBalance, targetAccountNumber);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
