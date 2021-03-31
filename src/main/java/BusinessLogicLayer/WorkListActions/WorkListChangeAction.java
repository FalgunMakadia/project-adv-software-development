package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.WorklistRequest.WorklistRequest;

public class WorkListChangeAction extends WorkListAction {

    public WorkListChangeAction(WorklistRequest worklistRequest, int worklistID) {
        super(worklistRequest, worklistID);
    }

    @Override
    public void processWorkList() {
        showWorkListDetail();
        String userInput = userInterface.getConfirmation("Assign to me ?");
        if(userInput.equals("y")) {
            String empUserName = loggedInUserContext.getUserName();
            boolean isUpdated = worklistDatabase.updateAssignee(worklistID, empUserName);
            if(isUpdated) {
                
            } else {
                userInterface.displayMessage("Error in updating work list details...");
            }
        }
    }
}
