package PresentationLayer.Pages.BankCentricPages;

import BusinessLogicLayer.WorkListRequestActions.IWorkListRequest;
import PresentationLayer.Pages.Page;

import java.util.Map;

public class WorkListTablePage extends Page {
    private Map<Integer, IWorkListRequest> workListRequestMap;
    public WorkListTablePage(Map<Integer, IWorkListRequest> workListRequestMap){
        this.workListRequestMap = workListRequestMap;
    }
    @Override
    public void printPage() {
        System.out.println("============================================================================");
        System.out.printf("%10s %25s %10s %14s %10s",
                "RequestId", "Request Type", "Priority", "Account Number", "Handled By");
        System.out.println();
        System.out.println("=============================================================================");
        for(Map.Entry<Integer, IWorkListRequest> entry: workListRequestMap.entrySet()) {
            IWorkListRequest worklistRequest = entry.getValue();
            System.out.format("%10s %25s %10s %14s %10s",
                    entry.getKey(),
                    worklistRequest.getRequestType(),
                    worklistRequest.getPriority(),
                    worklistRequest.getAccountNumber(),
                    worklistRequest.getHandledBy());
            System.out.println();
        }
    }
}
