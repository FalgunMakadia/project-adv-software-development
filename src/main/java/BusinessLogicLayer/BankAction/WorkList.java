package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.WorkListActions.*;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;
import DataAccessLayer.OperationDatabase.IWorklistOperationDatabase;
import PresentationLayer.Pages.IPage;

import java.util.HashMap;
import java.util.Map;

public class WorkList extends Action {
    private static final int EXIT = 0;
    private static final String CHANGE_REQUEST = "Change Personal Details";
    private static final String CREATE_ACCOUNT_REQUEST = "Open New Account";
    private static final String menuLabel = "WorkList";

    private IOperationDatabaseFactory operationDatabaseFactory;
    private IWorklistOperationDatabase workListOperationDatabase;
    private Map<Integer, IWorkListRequest> workListRequestMap;
    private IPage workListPage;
    private Map<String, IWorkListAction> workListActionMap;

    public WorkList() {
        setCurrentPageInContext();
        operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        workListOperationDatabase = operationDatabaseFactory.createWorkListOperationDatabase();
        workListRequestMap = new HashMap<>();
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
            } while(loggedInUserContext.getCurrentPage().equals(menuLabel)
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
