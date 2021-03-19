package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IAccountDatabase;
import DataAccessLayer.IDatabaseFactory;

import java.sql.SQLException;

public class Withdraw extends Action {
    private static final String menuLabel = "Withdraw";
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    @Override
    public void performAction() {
        int previousBalance;
        int withdrawAmount;
        int finalBalance;
        int output;
        String accountNumber = loggedInUserContext.getAccountNumber();

        System.out.println("Withdraw");
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        IAccountDatabase accountDatabase = databaseFactory.createAccountDatabase();

        try {
            previousBalance = accountDatabase.getUserBalance(accountNumber);
            userInterface.displayMessage("Current Balance:" + previousBalance);
            withdrawAmount = Integer.parseInt(userInterface.getUserInputInMultipleOfTen("Please enter Withdraw amount (only in multiple of 10): "));

            if(withdrawAmount > previousBalance) {
                while(withdrawAmount > previousBalance){
                    userInterface.displayMessage("You can not Withdraw more than your balance!");
                    withdrawAmount = Integer.parseInt(userInterface.getUserInputInMultipleOfTen("Please enter Withdraw amount (only in multiple of 10): "));
                }
            }

            String confirm = userInterface.getConfirmation("Are you sure you want to Withdraw " + withdrawAmount + " from Account Number " + accountNumber + "?");
            if(confirm.equalsIgnoreCase("y")){
                finalBalance = previousBalance - withdrawAmount;

                output = accountDatabase.updateBalance(finalBalance, accountNumber);
                if(output == 1){
                    userInterface.displayMessage("Withdraw Success!");
                    userInterface.displayMessage("Updated Balance: " + finalBalance);
                    userInterface.insertEmptyLine();
                    userInterface.insertEmptyLine();
                } else {
                    userInterface.displayMessage("Withdraw request failed!");
                    accountDatabase.updateBalance(previousBalance, accountNumber);
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
