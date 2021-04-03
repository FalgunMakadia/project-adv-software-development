package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.WorkListActions.IWorkListAction;
import BusinessLogicLayer.WorkListActions.WorkListChangeAction;
import BusinessLogicLayer.WorkListActions.WorkListNewAccountRequest;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;
import DataAccessLayer.IWorklistDatabase;
import PresentationLayer.Pages.IPage;

import java.util.HashMap;
import java.util.Map;

public class WorkList extends Action {
    private static final int EXIT = 0;
    private static final String CHANGE_REQUEST = "change personal details";
    private static final String CREATE_ACCOUNT_REQUEST = "Open New Account";

    private static final String menuLabel = "WorkList";
    private IWorklistDatabase worklistDatabase;
    private Map<Integer, WorklistRequest> worklistRequestMap;
    private IPage workListPage;

    public WorkList() {
        setCurrentPageInContext();
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        worklistDatabase = databaseFactory.createWorkListDatabase();
        worklistRequestMap = new HashMap<>();

    }

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }

    @Override
    public void performAction() {
        System.out.println("WorkList");
        this.worklistRequestMap = worklistDatabase.getWorkLists();
        if(this.worklistRequestMap.size() > 0) {
            workListPage = bankCentricPagesFactory.createWorkListTable(worklistRequestMap);
            workListPage.printPage();
            userInterface.displayMessage("Please Enter Number Worklist ID to " +
                    "process request and enter 0 to Return back to Main Menu");
            int userInput;
            do {
                userInput = Integer.parseInt(userInterface.getMandatoryIntegerUserInput("Enter Value:"));
                WorklistRequest worklistRequest = worklistDatabase.getWorkListRequest(userInput);
                if(null != worklistRequest) {
                    IWorkListAction workListAction;
                    if(worklistRequest.getRequestType().equals(CHANGE_REQUEST)) {
                        workListAction = new WorkListChangeAction(worklistRequest, userInput);
                        workListAction.processWorkList();
                    } else if(worklistRequest.getRequestType().equals(CREATE_ACCOUNT_REQUEST)) {
                        workListAction = new WorkListNewAccountRequest(worklistRequest, userInput);
                        workListAction.processWorkList();
                    }
                }
            } while(loggedInUserContext.getCurrentPage().equals(menuLabel)
                    && userInput != EXIT);
        }
    }
}
