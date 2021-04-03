package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IAccountDatabase;
import DataAccessLayer.IDatabaseFactory;
import PresentationLayer.MenuRouting.IMenuRoutingCommand;

public class ExistingBankAccount extends Action {
    private static final String menuLabel = "Existing Bank Account";
    IDatabaseFactory databaseFactory;

    public ExistingBankAccount() {
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
        setCurrentPageInContext();
        String accountNumber = userInterface.getMandatoryUserInput("Enter Account Number: ");
        validateLongInputFormat(accountNumber);
        IAccountDatabase accountDatabase = databaseFactory.createAccountDatabase();
        if (accountDatabase.verifyAccountNumber(accountNumber)) {
            loggedInUserContext.setAccountNumber(accountNumber);
            IMenuRoutingCommand command = presentationFactory.createExistingBankAccountCommand();
            command.execute();
        }
        userInterface.insertEmptyLine();
    }
}
