package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.User.AbstractProfile;

public class WorkListChangeAction extends WorkListAction {

    public WorkListChangeAction(IWorkListRequest workListRequest, int workListID) {
        super(workListRequest, workListID);
    }

    @Override
    public void processWorkList() {
        showWorkListDetail();

        boolean isAssigned = assignWorkList();
        if (isAssigned) {
            showComparisonOfUserDetails();

            String processInput = userInterface.getConfirmation("Do you want to process this change");
            if (processInput.equalsIgnoreCase(YES)) {
                boolean isDetailsUpdated = customerDatabase.
                        updateCustomerProfile(worklistRequest.getAccountNumber(), worklistRequest.getUser());
                workListDatabase.updateWorkListStatus(workListID, isDetailsUpdated);
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
        AbstractProfile oldProfileAbstractDetails = null;
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
