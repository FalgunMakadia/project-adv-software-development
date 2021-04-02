package PresentationLayer.CommonPages;

import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.util.Map;

public class WorklistTable implements IWorklistTable {
    @Override
    public void printWorkListTable(Map<Integer, WorklistRequest> worklistRequestMap) {
        System.out.println("============================================================================");
        System.out.printf("%10s %25s %10s %14s %10s",
                "RequestId", "Request Type", "Priority", "Account Number", "Handled By");
        System.out.println();
        System.out.println("=============================================================================");
        for(Map.Entry<Integer, WorklistRequest> entry: worklistRequestMap.entrySet()) {
            WorklistRequest worklistRequest = entry.getValue();
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
