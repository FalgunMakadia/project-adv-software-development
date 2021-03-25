package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.Action;

public class EnrollNewEmployee extends Action {
    private static final String menuLabel = "WorkList";
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage("BankStatement");
    }
    @Override
    public void performAction() {
        setCurrentPageInContext();
        System.out.println("Enroll New Employee");
         userInterface.displayMessage("Please enter the details of following fields:");
        userInterface.displayMessage("Note: (*) are mandatory fields.");
        userInterface.insertEmptyLine();

        String input;
        do {

            input = userInterface.getMandatoryUserInput("First Name*: ");
            newEmployee.setFirstName(input);
            input = userInterface.getMandatoryUserInput("Last Name*: ");
            newEmployee.setLastName(input);
            input = userInterface.getUserInput("Middle Name: ");
            newEmployee.setMiddleName(input);
            input = userInterface.getMandatoryUserInput("Address Line 1*: ");
            newEmployee.setAddressLine1(input);
            input = userInterface.getUserInput("Address Line 2: ");
            newEmployee.setAddressLine2(input);
            input = userInterface.getMandatoryUserInput("City*: ");
            newEmployee.setCity(input);
            input = userInterface.getMandatoryUserInput("State/ Province*: ");
            newEmployee.setProvince(input);
            input = userInterface.getMandatoryUserInput("Postal Code*: ");
            newEmployee.setPostalCode(input);
            input = userInterface.getMandatoryUserInput("Email Address*: ");
            newEmployee.setEmailAddress(input);
            input = userInterface.getMandatoryIntegerUserInput("Contact Number*: ");
            newEmployee.setContact(input);
            input = userInterface.getMandatoryUserInput("Passport Number*: ");
            newEmployee.setPassport(input);
            input = userInterface.getMandatoryUserInput("SSN*: ");
            newEmployee.setSsnNo(input);
            input = userInterface.getConfirmation("Do you want to Edit?  Y or N ").toUpperCase();
        } while (input.equals("Y"));
    }
}

    }
}
