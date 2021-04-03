package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.sql.SQLException;

public class WorkListChangeAction extends WorkListAction {

    public WorkListChangeAction(WorklistRequest worklistRequest, int worklistID) {
        super(worklistRequest, worklistID);
    }

    @Override
    public void processWorkList() {
        showWorkListDetail();

        boolean isAssigned = assignWorklist();
        if (isAssigned) {
            showComparisonOfUserDetails();

            String processInput = userInterface.getConfirmation("Do you want to process this change");
            if (processInput.equalsIgnoreCase("y")) {
                boolean isDetailsUpdated = customerDatabase.
                        updateUser(worklistRequest.getAccountNumber(), worklistRequest.getUser());
                worklistDatabase.updateProcessStatus(worklistID, isDetailsUpdated);
                if (isDetailsUpdated) {
                    userInterface.displayMessage("ProfileAbstract details updated successfully");
                } else {
                    userInterface.displayMessage("Error in updating profile details");
                }
            }
            returnToMainMenu();
        } else {
            userInterface.displayMessage("Error in updating work list details...");
        }
    }

    private void showComparisonOfUserDetails() {
        ProfileAbstract oldProfileAbstractDetails = null;
        oldProfileAbstractDetails = customerDatabase.getUser(worklistRequest.getAccountNumber());
        userInterface.displayMessage("====Old Details====");
        userDetailPage.printUserDetails(oldProfileAbstractDetails);
        userInterface.insertEmptyLine();

        userInterface.displayMessage("=====New ProfileAbstract Details====");
        userDetailPage.printUserDetails(worklistRequest.getUser());
        userInterface.insertEmptyLine();
    }
}
