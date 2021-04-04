package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;

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
                        updateCustomerProfile(worklistRequest.getAccountNumber(), worklistRequest.getUser());
                worklistDatabase.updateWorkListStatus(worklistID, isDetailsUpdated);
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
        oldProfileAbstractDetails = customerDatabase.getCustomerProfile(worklistRequest.getAccountNumber());
        userDetailPage = bankCentricPagesFactory.createUserDetailPage(oldProfileAbstractDetails);
        userInterface.displayMessage("====Old Details====");
        userDetailPage.printPage();
        userInterface.insertEmptyLine();

        userInterface.displayMessage("=====New ProfileAbstract Details====");
        userDetailPage = bankCentricPagesFactory.createUserDetailPage(worklistRequest.getUser());
        userDetailPage.printPage();
        userInterface.insertEmptyLine();
    }
}
