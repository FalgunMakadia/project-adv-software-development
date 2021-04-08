package BusinessLogicLayer.CommonAction;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.IUserFactory;
import BusinessLogicLayer.User.LoggedInUserContext;
import BusinessLogicLayer.User.UserFactory;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.MenuRouting.IMenuRoutingFactory;
import PresentationLayer.Pages.BankCentricPages.IBankCentricPagesFactory;
import PresentationLayer.Pages.CommonPages.ICommonPagesFactory;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;
import PresentationLayer.Pages.CustomerCentricPages.ICustomerCentricPagesFactory;
import PresentationLayer.PresentationFactory;

public abstract class AbstractAction implements IAbstractAction {
    protected IUserInterfacePage userInterface;
    protected ILoggedInUserContext loggedInUserContext;
    protected IPresentationFactory presentationFactory;
    protected IMenuRoutingFactory menuRoutingFactory;
    protected IBankCentricPagesFactory bankCentricPagesFactory;
    protected ICommonPagesFactory commonPagesFactory;
    protected ICustomerCentricPagesFactory customerCentricPagesFactory;
    protected IDatabaseFactory databaseFactory;
    protected IUserFactory userFactory;
    public AbstractAction() {
        databaseFactory = new DatabaseFactory();
        presentationFactory = new PresentationFactory();
        commonPagesFactory = presentationFactory.createCommonPagesFactory();
        userInterface = commonPagesFactory.createUserInterface();
        loggedInUserContext = LoggedInUserContext.instance();
        menuRoutingFactory = presentationFactory.createMenuRoutingFactory();
        bankCentricPagesFactory = presentationFactory.createBankCentricPagesFactory();
        customerCentricPagesFactory = presentationFactory.createCustomerCentricPagesFactory();
        userFactory = new UserFactory();
    }

    protected int convertStringToInteger(String input) {
        int choiceNumber = 0;
        try {
            choiceNumber = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input.");
        }
        return choiceNumber;
    }

    protected long convertStringToLong(String input) {
        long choiceNumber = 0;
        try {
            choiceNumber = Long.parseLong(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input.");
        }
        return choiceNumber;
    }

    protected boolean validateLongInputFormat(String input) {
        boolean validity = true;
        long choiceNumber = 0;
        try {
            choiceNumber = Long.parseLong(input);

        } catch (Exception exception) {
            validity = false;
            throw new IllegalArgumentException("Invalid input.");
        }
        return validity;
    }

    public abstract void performAction();

    public abstract String getActionTitle();

    protected abstract void setCurrentPageInContext();
}
