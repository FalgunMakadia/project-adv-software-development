package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;
import DataAccessLayer.IWorklistDatabase;

public class WorkList extends Action {
    private static final String menuLabel = "WorkList";
    private IWorklistDatabase worklistDatabase;

    public WorkList() {
        setCurrentPageInContext();
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        worklistDatabase = databaseFactory.createWorkListDatabase();
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
        worklistDatabase.getWorkLists();
    }
}
