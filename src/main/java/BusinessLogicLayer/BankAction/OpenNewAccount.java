package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.BankAction.FormActionCommands.BackToMainMenuCommand;
import BusinessLogicLayer.BankAction.FormActionCommands.EditFormCommand;
import BusinessLogicLayer.BankAction.FormActionCommands.FormActionCommand;
import BusinessLogicLayer.BankAction.FormActionCommands.SaveOpenNewAccountFormCommand;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CustomerAction.FormCommands.*;
import BusinessLogicLayer.User.Customer;
import BusinessLogicLayer.User.User;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class OpenNewAccount extends Action {
    IDatabaseFactory databaseFactory;
    private static final String menuLabel = "Open New Account";
    Map<Integer, FormActionCommand> openNewAccountStateMap;
    private Map<Integer, FormCommand> openNewAccountFormFieldMap;
    User customer;
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    public OpenNewAccount() {
        super();
        databaseFactory = new DatabaseFactory();
        customer = new Customer();
        getOpenNewAccountFormFieldMap();
        openNewAccountStateMap = new LinkedHashMap<>();
        openNewAccountStateMap.put(1, new EditFormCommand("Edit", customer, openNewAccountFormFieldMap));
        openNewAccountStateMap.put(2, new SaveOpenNewAccountFormCommand("Save", customer));
        openNewAccountStateMap.put(3, new BackToMainMenuCommand("Back to main menu"));
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }

    public void performAction() {
        setCurrentPageInContext();
        userInterface.displayMessage("Please enter the details of following fields:");
        userInterface.displayMessage("Note: (*) are mandatory fields.");
        userInterface.insertEmptyLine();

        Iterator<Map.Entry<Integer, FormCommand>> iterator = openNewAccountFormFieldMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, FormCommand> formQuestionEntry = iterator.next();
            FormCommand formCommand = formQuestionEntry.getValue();
            formCommand.execute();
        }


        while (loggedInUserContext.checkCurrentPageStatus(menuLabel)) {
            int key = 1;
            for (int i = 0; i < openNewAccountStateMap.size(); i++) {
                FormActionCommand formState = openNewAccountStateMap.get(key);
                System.out.println(key + ". " + formState.getMenuLabel());
                key = key + 1;
            }
            String action = userInterface.getMandatoryIntegerUserInput("Enter any Number between 1-" + openNewAccountStateMap.size() + " to perform appropriate action:");

            FormActionCommand formCommand = openNewAccountStateMap.get(Integer.parseInt(action));
            formCommand.execute();

        }
    }

    private void getOpenNewAccountFormFieldMap() {
        openNewAccountFormFieldMap = new LinkedHashMap<>();
        openNewAccountFormFieldMap.put(1, new FirstNameCommand(customer));
        openNewAccountFormFieldMap.put(2, new MiddleNameCommand(customer));
        openNewAccountFormFieldMap.put(3, new LastNameCommand(customer));
        openNewAccountFormFieldMap.put(4, new AddressLine1Command(customer));
        openNewAccountFormFieldMap.put(5, new AddressLine2Command(customer));
        openNewAccountFormFieldMap.put(6, new CityCommand(customer));
        openNewAccountFormFieldMap.put(7, new ProvinceCommand(customer));
        openNewAccountFormFieldMap.put(8, new ContactCommand(customer));
        openNewAccountFormFieldMap.put(9, new EmailCommand(customer));
        openNewAccountFormFieldMap.put(10, new PassPortNumberCommand(customer));
        openNewAccountFormFieldMap.put(11, new SSNNumberCommand(customer));
        openNewAccountFormFieldMap.put(12, new DOBCommand(customer));
    }

}
