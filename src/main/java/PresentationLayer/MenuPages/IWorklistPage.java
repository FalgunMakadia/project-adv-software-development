package PresentationLayer.MenuPages;

import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.util.Map;

public interface IWorklistPage {
    void showWorklist(Map<Integer, WorklistRequest> worklistRequestMap);
}
