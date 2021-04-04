package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;
import PresentationLayer.MenuRouting.IMenuRoutingCommand;

public class ExistingBankAccount extends Action {
    private static final String menuLabel = "Existing Bank Account";
    private IAccountOperationDatabase accountOperationDatabase;

    public ExistingBankAccount() {
        IOperationDatabaseFactory operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        accountOperationDatabase = operationDatabaseFactory.createAccountOperationDatabase();
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
        setCurrentPageInContext();
        String accountNumber = userInterface.getMandatoryUserInput("Enter Account Number: ");
        validateLongInputFormat(accountNumber);

        if (accountOperationDatabase.verifyAccountNumber(accountNumber)) {
            loggedInUserContext.setAccountNumber(accountNumber);
            IMenuRoutingCommand command = menuRoutingFactory.createExistingBankAccountCommand();
            command.execute();
        }
        userInterface.insertEmptyLine();
    }
}
