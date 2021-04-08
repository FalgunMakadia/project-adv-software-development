package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.CommonAction.AbstractAction;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;
import PresentationLayer.MenuRouting.IMenuRoutingCommand;

public class ExistingBankAccountAction extends AbstractAction {
    private static final String ACTION_TITLE = "Existing Bank Account";

    private IAccountOperationDatabase accountOperationDatabase;

    public ExistingBankAccountAction() {
        IOperationDatabaseFactory operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        accountOperationDatabase = operationDatabaseFactory.createAccountOperationDatabase();
    }

    @Override
    public String getActionTitle() {
        return ACTION_TITLE;
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
