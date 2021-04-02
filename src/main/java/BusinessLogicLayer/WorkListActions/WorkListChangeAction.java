package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.User.User;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import DataAccessLayer.ICustomerDatabase;

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

                if (isDetailsUpdated) {
                    userInterface.displayMessage("User details updated successfully");
                } else {
                    userInterface.displayMessage("Error in updating user details");
                }
            }

            returnToMainMenu();
        } else {
            userInterface.displayMessage("Error in updating work list details...");
        }
    }

    private void showComparisonOfUserDetails() {
        User oldUserDetails = null;
        try {
            oldUserDetails = customerDatabase.getUser(worklistRequest.getAccountNumber());
            userInterface.displayMessage("====Old Details====");
            userDetailPage.printUserDetails(oldUserDetails);
            userInterface.insertEmptyLine();

            userInterface.displayMessage("=====New User Details====");
            userDetailPage.printUserDetails(worklistRequest.getUser());
            userInterface.insertEmptyLine();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
