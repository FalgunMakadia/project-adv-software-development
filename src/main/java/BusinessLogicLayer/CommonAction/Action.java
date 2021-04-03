package BusinessLogicLayer.CommonAction;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.MenuRouting.IMenuRoutingFactory;
import PresentationLayer.Pages.BankCentricPages.IBankCentricPagesFactory;
import PresentationLayer.Pages.CommonPages.ICommonPagesFactory;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;
import PresentationLayer.Pages.CustomerCentricPages.ICustomerCentricPagesFactory;
import PresentationLayer.PresentationFactory;

public abstract class Action implements IAction{
    protected IUserInterfacePage userInterface = null;
    protected ILoggedInUserContext loggedInUserContext;
    protected IPresentationFactory presentationFactory;
    protected IMenuRoutingFactory menuRoutingFactory;
    protected IBankCentricPagesFactory bankCentricPagesFactory;
    protected ICommonPagesFactory commonPagesFactory;
    protected ICustomerCentricPagesFactory customerCentricPagesFactory;
    public Action() {
        presentationFactory = new PresentationFactory();
        commonPagesFactory = presentationFactory.createCommonPagesFactory();
        userInterface = commonPagesFactory.createUserInterface();
        loggedInUserContext = LoggedInUserContext.instance();
        menuRoutingFactory = presentationFactory.createMenuRoutingFactory();
        bankCentricPagesFactory = presentationFactory.createBankCentricPagesFactory();
        customerCentricPagesFactory = presentationFactory.createCustomerCentricPagesFactory();
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

    protected double convertStringToDouble(String input) {
        double choiceNumber = 0;
        try {
            choiceNumber = Double.parseDouble(input);
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

    protected boolean validateIntegerInputFormat(String input) {
        boolean validity = true;
        int choiceNumber = 0;
        try {
            choiceNumber = Integer.parseInt(input);

        } catch (Exception exception) {
            validity = false;
            throw new IllegalArgumentException("Invalid input.");
        }
        return validity;
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

    public abstract String getMenuLabel();

    protected abstract void setCurrentPageInContext();
}
