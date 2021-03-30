package PresentationLayer.MenuPages;

import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.util.Map;

public class WorklistPage implements IWorklistPage {
    private Map<Integer, WorklistRequest> worklistRequestMap;

    public WorklistPage() {
        this.worklistRequestMap = worklistRequestMap;
    }

    @Override
    public void showWorklist(Map<Integer, WorklistRequest> worklistRequestMap) {
        System.out.println("============================================================================");
        System.out.printf("%10s %12s %10s %14s %10s",
                "RequestId", "Request Type", "Priority", "Account Number", "Handled By");
        System.out.println();
        System.out.println("=============================================================================");
        for(Map.Entry<Integer, WorklistRequest> entry: worklistRequestMap.entrySet()) {
            WorklistRequest worklistRequest = entry.getValue();
            System.out.format("%10s %12s %10s %14s %10s",
                    entry.getKey(),
                    worklistRequest.getRequestType(),
                    worklistRequest.getPriority(),
                    worklistRequest.getAccountNumber(),
                    worklistRequest.getHandledBy());
            System.out.println();
        }
    }
}
