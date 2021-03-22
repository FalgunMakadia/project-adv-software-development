package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.User.User;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import DataAccessLayer.*;

import java.sql.SQLException;
import java.util.Map;

public class UpdatePersonalDetails extends Action {
    private static final String menuLabel = "Update Personal Details";
    private IDatabaseFactory databaseFactory;
    private ICustomerDatabase customerDatabase;
    private IWorklistDatabase worklistDatabase;
    private boolean isUpdated = false;

    public UpdatePersonalDetails() {
        this.databaseFactory = new DatabaseFactory();
        this.customerDatabase = databaseFactory.createCustomerDatabase();
        this.worklistDatabase = databaseFactory.createWorkListDatabase();
    }

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    public void performAction() {
        isUpdated = false;
        userInterface.displayMessage("============UPDATE PERSONAL DETAILS=====================");
        String currentUserAccountNumber = loggedInUserContext.getAccountNumber();
        setCurrentPageInContext();
        System.out.println("Update Personal Details");
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        ICustomerDatabase customerDatabase = databaseFactory.createCustomerDatabase();
        try {
            User user = customerDatabase.getUser(currentUserAccountNumber);
            user = updateMandatoryPersonalDetails(user);
            if(isUpdated) {
                WorklistRequest worklistRequest = new WorklistRequest("change", currentUserAccountNumber,user);
                worklistDatabase.addWorkListRequest(worklistRequest);
            } else {
                System.out.println("user not changed");
            }
            System.out.println("Welcome: " + user.getFirstName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private User updateMandatoryPersonalDetails(User user) {
        Map<String, String> fieldSet = user.getListOfMandatoryFields();
        for (Map.Entry<String, String> entry : fieldSet.entrySet()) {
            entry.setValue(updateField(entry));
        }
        user.setListOfMandatoryFields(fieldSet);
        return user;
    }

    private String updateField(Map.Entry<String, String> entrySet) {
        String fieldName = entrySet.getKey();
        String currentValue = entrySet.getValue();
        userInterface.displayMessage(fieldName + " is " + currentValue);
        String userConfirmation = userInterface.getConfirmation("Do you want to edit " + fieldName + " ?");
        if (userConfirmation.equals("y")){
            String input = userInterface.getMandatoryUserInput("Enter New " + fieldName + ": ");
            if(input != currentValue) {
                isUpdated = true;
            }
            return input;
        }else if(userConfirmation.equals("n")) {
            return currentValue;
        } else {
            userInterface.displayMessage("Invalid User Input Please try again: Input should be y or n");
            updateField(entrySet);
        }
        return currentValue;
    }
    
    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }
}
