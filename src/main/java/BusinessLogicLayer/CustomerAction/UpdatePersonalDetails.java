package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.User.User;
import DataAccessLayer.ICustomerDatabase;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;

import java.sql.SQLException;
import java.util.Map;

public class UpdatePersonalDetails extends Action {
    private static final String menuLabel = "Update Personal Details";
    private IDatabaseFactory databaseFactory;
    private ICustomerDatabase customerDatabase;

    public UpdatePersonalDetails() {
        this.databaseFactory = new DatabaseFactory();
        this.customerDatabase = databaseFactory.createCustomerDatabase();
    }

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    public void performAction() {
        userInterface.displayMessage("============UPDATE PERSONAL DETAILS=====================");
        String currentUserAccountNumber = loggedInUserContext.getAccountNumber();
        try {
            User user = customerDatabase.getUser(currentUserAccountNumber);
            User updatedUser = updateMandatoryPersonalDetails(user);
            if(user.equals(updatedUser)) {
                System.out.println("User not changed");
            } else {
                System.out.println("user changed");
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
            return input;
        }else if(userConfirmation.equals("n")) {
            return currentValue;
        } else {
            userInterface.displayMessage("Invalid User Input Please try again: Input should be y or n");
            updateField(entrySet);
        }
        return currentValue;
    }
}
