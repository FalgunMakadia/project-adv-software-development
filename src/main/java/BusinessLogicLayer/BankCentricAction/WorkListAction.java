package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.WorkListActions.*;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;
import DataAccessLayer.OperationDatabase.IWorklistOperationDatabase;
import PresentationLayer.Pages.IPage;

import java.util.HashMap;
import java.util.Map;

public class WorkListAction extends Action {
    private static final int EXIT = 0;
    private static final String CHANGE_REQUEST = "Change Personal Details";
    private static final String CREATE_ACCOUNT_REQUEST = "Open New Account";
    private static final String ACTION_TITLE = "WorkList";

    private IOperationDatabaseFactory operationDatabaseFactory;
    private IWorklistOperationDatabase workListOperationDatabase;
    private Map<Integer, IWorkListRequest> workListRequestMap;
    private IPage workListPage;
    private Map<String, IWorkListAction> workListActionMap;

    public WorkListAction() {
        setCurrentPageInContext();
        operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        workListOperationDatabase = operationDatabaseFactory.createWorkListOperationDatabase();
        workListRequestMap = new HashMap<>();
    }

    @Override
    public String getActionTitle() {
        return ACTION_TITLE;
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(ACTION_TITLE);
    }

    @Override
    public void performAction() {
        this.workListRequestMap = workListOperationDatabase.getWorkList();
        if(this.workListRequestMap.size() > 0) {
            workListPage = bankCentricPagesFactory.createWorkListTable(workListRequestMap);
            workListPage.printPage();
            userInterface.displayMessage("Please Enter Number Worklist ID to " +
                    "process request and enter 0 to Return back to Main Menu");
            int userInput;
            do {
                userInput = Integer.parseInt(userInterface.getMandatoryIntegerUserInput("Enter Value:"));
                IWorkListRequest workListRequest = workListOperationDatabase.getWorkListRequest(userInput);
                workListActionMap = getWorkListActionMap(workListRequest, userInput);
                if(null != workListRequest) {
                    IWorkListAction workListAction = workListActionMap.get(workListRequest.getRequestType());
                    workListAction.processWorkList();
                }
            } while(loggedInUserContext.getCurrentPage().equals(ACTION_TITLE)
                    && userInput != EXIT);
        }
    }

    private Map<String, IWorkListAction> getWorkListActionMap(IWorkListRequest workListRequest, int userInput) {
        IWorkListActionFactory workListActionFactory = new WorkListActionFactory();
        workListActionMap = new HashMap<>();
        workListActionMap.put(CHANGE_REQUEST, workListActionFactory.createWorkListChangeAction(workListRequest, userInput));
        workListActionMap.put(CREATE_ACCOUNT_REQUEST, workListActionFactory.createWorkListNewAccountRequest(workListRequest, userInput));

        return workListActionMap;
    }
}
