package BusinessLogicLayer.WorkListRequestActions;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.IUserFactory;
import BusinessLogicLayer.User.UserFactory;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;
import DataAccessLayer.ProfileDatabase.ICustomerProfileDatabase;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import DataAccessLayer.OperationDatabase.IWorklistOperationDatabase;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import PresentationLayer.Pages.BankCentricPages.IBankCentricPagesFactory;
import PresentationLayer.Pages.CommonPages.ICommonPagesFactory;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.Pages.IPage;
import PresentationLayer.PresentationFactory;

public abstract class AbstractWorkListRequestAction implements IWorkListRequestAction {
    protected static final String YES = "y";

    protected IWorkListRequest workListRequest;
    protected int workListID;
    protected IUserInterfacePage userInterface;
    protected ILoggedInUserContext loggedInUserContext;
    protected IWorklistOperationDatabase workListDatabase;
    protected ICustomerProfileDatabase customerDatabase;
    protected IPage userDetailPage;
    protected IDatabaseFactory databaseFactory;
    protected IPresentationFactory presentationFactory;
    protected IBankCentricPagesFactory bankCentricPagesFactory;
    protected ICommonPagesFactory commonPagesFactory;
    protected IOperationDatabaseFactory operationDatabaseFactory;
    protected IProfileDatabaseFactory profileDatabaseFactory;
    protected IUserFactory userFactory;
    public AbstractWorkListRequestAction(IWorkListRequest workListRequest, int workListID) {
        this.workListRequest = workListRequest;
        this.workListID = workListID;

        userFactory = new UserFactory();
        presentationFactory = new PresentationFactory();
        commonPagesFactory = presentationFactory.createCommonPagesFactory();
        this.userInterface = commonPagesFactory.createUserInterface();
        this.bankCentricPagesFactory = presentationFactory.createBankCentricPagesFactory();
        this.loggedInUserContext = userFactory.getLoggedInUserContext();

        this.databaseFactory = new DatabaseFactory();
        this.operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        this.profileDatabaseFactory = databaseFactory.createProfileDatabaseFactory();
        this.workListDatabase = operationDatabaseFactory.createWorkListOperationDatabase();
        this.customerDatabase = profileDatabaseFactory.createCustomerProfileDatabase();
    }

    public void showWorkListDetail() {
        this.userInterface.displayMessage("Request ID: " + workListID);
        this.userInterface.displayMessage("Request Type: " + workListRequest.getRequestType());
        this.userInterface.displayMessage("Account Number: " + workListRequest.getAccountNumber());
        this.userInterface.displayMessage("Priority: " + workListRequest.getPriority());
    }

    public Boolean assignWorkList() {
        String userInput = userInterface.getConfirmation("Assign to me ?");
        if (userInput.equalsIgnoreCase(YES)) {
            String empUserName = loggedInUserContext.getUserName();
            boolean isUpdated = workListDatabase.assignWorkListRequest(workListID, empUserName);
            return isUpdated;
        }
        return false;
    }

    public void returnToMainMenu() {
        loggedInUserContext.clearCurrentPage();
    }
}
