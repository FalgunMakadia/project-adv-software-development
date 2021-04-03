package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.WorklistRequest.WorklistRequest;

public class WorkListNewAccountRequest extends WorkListAction {

    public WorkListNewAccountRequest(WorklistRequest worklistRequest, int worklistID) {
        super(worklistRequest, worklistID);
    }

    @Override
    public void processWorkList() {
        showWorkListDetail();

        boolean isAssigned = assignWorklist();
        if (isAssigned) {
            showUserDetails();

            String processInput = userInterface
                    .getConfirmation("Do you want to process with this New Account Request ?");
            if (processInput.equalsIgnoreCase("y")) {
                boolean isUserCreated = customerDatabase.add(worklistRequest.getUser());
                worklistDatabase.updateProcessStatus(worklistID, isUserCreated);
                if (isUserCreated) {
                    userInterface.displayMessage("New Account is Created");
                } else {
                    userInterface.displayMessage("Error in Creating New ProfileAbstract");
                }
            }
            returnToMainMenu();
        } else {
            userInterface.displayMessage("Error in updating work list details...");
        }
    }

    private void showUserDetails() {
        userDetailPage = bankCentricPagesFactory.createUserDetailPage(worklistRequest.getUser());
        userInterface.displayMessage("=====New ProfileAbstract Details====");
        userDetailPage.printPage();
        userInterface.insertEmptyLine();
    }
}
