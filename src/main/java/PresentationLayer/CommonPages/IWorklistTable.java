package PresentationLayer.CommonPages;

import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.util.Map;

public interface IWorklistTable {
    void printWorkListTable(Map<Integer, WorklistRequest> worklistRequestMap);
}
