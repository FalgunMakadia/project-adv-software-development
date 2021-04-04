package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
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

public abstract class WorkListAction implements IWorkListAction {
    protected WorklistRequest worklistRequest;
    protected int worklistID;
    protected IUserInterfacePage userInterface;
    protected ILoggedInUserContext loggedInUserContext;
    protected IWorklistOperationDatabase worklistDatabase;
    protected ICustomerProfileDatabase customerDatabase;
    protected IPage userDetailPage;
    protected IDatabaseFactory databaseFactory;
    protected IPresentationFactory presentationFactory;
    protected IBankCentricPagesFactory bankCentricPagesFactory;
    protected ICommonPagesFactory commonPagesFactory;
    protected IOperationDatabaseFactory operationDatabaseFactory;
    protected IProfileDatabaseFactory profileDatabaseFactory;

    public WorkListAction(WorklistRequest worklistRequest, int worklistID) {
        this.worklistRequest = worklistRequest;
        this.worklistID = worklistID;
        this.loggedInUserContext = LoggedInUserContext.instance();

        presentationFactory = new PresentationFactory();
        commonPagesFactory = presentationFactory.createCommonPagesFactory();
        this.userInterface = commonPagesFactory.createUserInterface();
        this.bankCentricPagesFactory = presentationFactory.createBankCentricPagesFactory();

        this.databaseFactory = new DatabaseFactory();
        this.operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        this.profileDatabaseFactory = databaseFactory.createProfileDatabaseFactory();
        this.worklistDatabase = operationDatabaseFactory.createWorkListOperationDatabase();
        this.customerDatabase = profileDatabaseFactory.createCustomerProfileDatabase();
    }

    public void showWorkListDetail() {
        this.userInterface.displayMessage("Request ID: " + worklistID);
        this.userInterface.displayMessage("Request Type: " + worklistRequest.getRequestType());
        this.userInterface.displayMessage("Account Number: " + worklistRequest.getAccountNumber());
        this.userInterface.displayMessage("Priority: " + worklistRequest.getPriority());
    }

    public Boolean assignWorklist() {
        String userInput = userInterface.getConfirmation("Assign to me ?");
        if (userInput.equalsIgnoreCase("y")) {
            String empUserName = loggedInUserContext.getUserName();
            boolean isUpdated = worklistDatabase.assignWorkListRequest(worklistID, empUserName);
            return isUpdated;
        }
        return false;
    }

    public void returnToMainMenu() {
        loggedInUserContext.setCurrentPage("");
    }
}
