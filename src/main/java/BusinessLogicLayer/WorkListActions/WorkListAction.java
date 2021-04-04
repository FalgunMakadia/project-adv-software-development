package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.ICustomerDatabase;
import DataAccessLayer.IDatabaseFactory;
import DataAccessLayer.IWorklistDatabase;
import PresentationLayer.MenuRouting.IMenuRoutingFactory;
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
    protected IWorklistDatabase worklistDatabase;
    protected ICustomerDatabase customerDatabase;
    protected IPage userDetailPage;
    IDatabaseFactory databaseFactory;
    protected IPresentationFactory presentationFactory;
    protected IBankCentricPagesFactory bankCentricPagesFactory;
    protected ICommonPagesFactory commonPagesFactory;

    public WorkListAction(WorklistRequest worklistRequest, int worklistID) {
        this.worklistRequest = worklistRequest;
        this.worklistID = worklistID;
        this.loggedInUserContext = LoggedInUserContext.instance();

        presentationFactory = new PresentationFactory();
        commonPagesFactory = presentationFactory.createCommonPagesFactory();
        this.userInterface = commonPagesFactory.createUserInterface();
        this.bankCentricPagesFactory = presentationFactory.createBankCentricPagesFactory();

        this.databaseFactory = new DatabaseFactory();
        this.worklistDatabase = databaseFactory.createWorkListDatabase();
        this.customerDatabase = databaseFactory.createCustomerDatabase();
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
            boolean isUpdated = worklistDatabase.updateAssignee(worklistID, empUserName);
            return isUpdated;
        }
        return false;
    }

    public void returnToMainMenu() {
        loggedInUserContext.setCurrentPage("");
    }
}
