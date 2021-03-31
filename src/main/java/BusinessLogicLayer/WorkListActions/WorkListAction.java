package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;
import DataAccessLayer.IWorklistDatabase;
import PresentationLayer.CommonPages.IUserDetailPage;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.PresentationFactory;

public abstract class WorkListAction {
    protected WorklistRequest worklistRequest;
    protected int worklistID;
    protected IUserInterface userInterface;
    protected ILoggedInUserContext loggedInUserContext;
    protected IWorklistDatabase worklistDatabase;
    protected IUserDetailPage userDetailPage;
    IDatabaseFactory databaseFactory;

    public WorkListAction(WorklistRequest worklistRequest, int worklistID) {
        this.worklistRequest = worklistRequest;
        this.worklistID = worklistID;
        this.loggedInUserContext = LoggedInUserContext.instance();

        IPresentationFactory presentationFactory = new PresentationFactory();
        this.userInterface = presentationFactory.createUserInterface();
        this.userDetailPage = presentationFactory.createUserDetailPage();

        this.databaseFactory = new DatabaseFactory();
        this.worklistDatabase = databaseFactory.createWorkListDatabase();
    }

    public abstract void processWorkList();

    public void showWorkListDetail() {
        this.userInterface.displayMessage("Request ID: " + worklistID);
        this.userInterface.displayMessage("Request Type: " + worklistRequest.getRequestType());
        this.userInterface.displayMessage("Account Number: " + worklistRequest.getAccountNumber());
        this.userInterface.displayMessage("Priority: " + worklistRequest.getPriority());
    }
}
