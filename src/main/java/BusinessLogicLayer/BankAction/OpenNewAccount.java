package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.User.Customer;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class OpenNewAccount extends Action {
    Customer customer = null;
    IDatabaseFactory databaseFactory;
    private static final String menuLabel = "Open New Account";
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    public OpenNewAccount() {
        super();
        customer = new Customer();
        databaseFactory = new DatabaseFactory();

    }
    private  String a (){
        return "";
    }
    public void performAction() {
        userInterface.displayMessage("Please enter the details of following fields:");
        userInterface.displayMessage("Note: (*) are mandatory fields.");
        userInterface.insertEmptyLine();


        String input = userInterface.getMandatoryUserInput("First Name*: ");
        customer.setFirstName(input);
        input = userInterface.getMandatoryUserInput("Last Name*: ");
        customer.setLastName(input);
        input = userInterface.getUserInput("Middle Name: ");
        customer.setMiddleName(input);
        input = userInterface.getMandatoryUserInput("Address Line 1*: ");
        customer.setAddressLine1(input);
        input = userInterface.getUserInput("Address Line 2: ");
        customer.setAddressLine2(input);
        input = userInterface.getMandatoryUserInput("City*: ");
        customer.setCity(input);
        input = userInterface.getMandatoryUserInput("State/ Province*: ");
        customer.setProvince(input);
        input = userInterface.getMandatoryUserInput("Postal Code*: ");
        customer.setPostalCode(input);
        input = userInterface.getMandatoryUserInput("Email Address*: ");
        customer.setEmailAddress(input);
        input = userInterface.getMandatoryIntegerUserInput("Contact Number*: ");
        customer.setContact(input);
        input = userInterface.getMandatoryUserInput("Passport Number*: ");
        customer.setPassport(input);
        input = userInterface.getMandatoryUserInput("SSN*: ");
        customer.setSsnNo(input);
        input = userInterface.getConfirmation("Do you want to save? ").toUpperCase();
        if (input.equals("Y")) {

        }

    }


}
