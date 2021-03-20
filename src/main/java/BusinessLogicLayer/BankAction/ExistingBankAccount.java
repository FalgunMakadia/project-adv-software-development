package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IAccountDatabase;
import DataAccessLayer.IDatabaseFactory;
import PresentationLayer.MenuPages.Command;

import java.sql.SQLException;

public class ExistingBankAccount extends Action {
    private static final String menuLabel = "Existing Bank Account";
    IDatabaseFactory databaseFactory;
    public ExistingBankAccount(){
         databaseFactory = new DatabaseFactory();
    }
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage("BankStatement");
    }
    @Override
    public void performAction() {
        try {
            setCurrentPageInContext();
            String accountNumber = userInterface.getMandatoryUserInput("Enter Account Number: ");
            validateLongInputFormat(accountNumber);
            IAccountDatabase accountDatabase = databaseFactory.createAccountDatabase();
            if (accountDatabase.verifyAccountNumber(accountNumber)){
                loggedInUserContext.setAccountNumber(accountNumber);
                Command command = presentationFactory.createExistingBankAccountCommand();
                command.execute();
            }
        }
        catch (SQLException exception){
            userInterface.displayMessage("Error occurred in database connection.");
        }
        catch (Exception exception){
            userInterface.displayMessage(exception.getMessage());
        }
        userInterface.insertEmptyLine();
    }
}
