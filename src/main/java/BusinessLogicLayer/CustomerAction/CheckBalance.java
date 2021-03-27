package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IAccountDatabase;
import DataAccessLayer.IDatabaseFactory;

import java.sql.SQLException;

public class CheckBalance extends Action {
    private static final String menuLabel = "Check Balance";

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
        String name = loggedInUserContext.getUserName();
        int currentBalance;

        userInterface.displayMessage("Check Balance");
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        IAccountDatabase accountDatabase = databaseFactory.createAccountDatabase();

        try {
            userInterface.displayMessage("Hello " + name);
            currentBalance = accountDatabase.getUserBalance(accountNumber);
            userInterface.displayMessage("Current Balance in your account number " + accountNumber + " is: " + currentBalance);
            userInterface.insertEmptyLine();
            userInterface.insertEmptyLine();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
