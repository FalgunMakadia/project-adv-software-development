package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;
import DataAccessLayer.IWorklistDatabase;
import PresentationLayer.CommonPages.IWorklistTable;

import java.util.HashMap;
import java.util.Map;

public class WorkList extends Action {
    private static final String menuLabel = "WorkList";
    private IWorklistDatabase worklistDatabase;
    private Map<Integer, WorklistRequest> worklistRequestMap;
    private IWorklistTable worklistPage;

    public WorkList() {
        setCurrentPageInContext();
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        worklistDatabase = databaseFactory.createWorkListDatabase();
        worklistRequestMap = new HashMap<>();
        worklistPage = presentationFactory.createWorklistTable();
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
            worklistPage.printWorkListTable(this.worklistRequestMap);
        }
    }
}
