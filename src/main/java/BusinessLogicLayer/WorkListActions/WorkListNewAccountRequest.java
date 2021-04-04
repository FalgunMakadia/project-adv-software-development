package BusinessLogicLayer.WorkListActions;

public class WorkListNewAccountRequest extends WorkListAction {

    public WorkListNewAccountRequest(IWorkListRequest workListRequest, int workListID) {
        super(workListRequest, workListID);
    }

    @Override
    public void processWorkList() {
        showWorkListDetail();

        boolean isAssigned = assignWorkList();
        if (isAssigned) {
            showUserDetails();

            String processInput = userInterface
                    .getConfirmation("Do you want to process with this New Account Request ?");
            if (processInput.equalsIgnoreCase(YES)) {
                boolean isUserCreated = customerDatabase.addNewCustomerProfile(worklistRequest.getUser());
                workListDatabase.updateWorkListStatus(workListID, isUserCreated);
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
        userInterface.displayMessage("=====New Customer Profile Details====");
        userDetailPage.printPage();
        userInterface.insertEmptyLine();
    }
}
