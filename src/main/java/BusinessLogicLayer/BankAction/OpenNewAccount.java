package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.BankAction.FormActionCommands.BackToMainMenuCommand;
import BusinessLogicLayer.BankAction.FormActionCommands.EditFormCommand;
import BusinessLogicLayer.BankAction.FormActionCommands.SaveOpenNewAccountFormCommand;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CustomerAction.FormCommands.*;
import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.ProfileAbstract;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class OpenNewAccount extends Action {
    private static final String menuLabel = "Open New Account";
    Map<Integer,IFormCommand> formActionCommandMap;
    private Map<Integer,IFormCommand> openNewAccountFormFieldMap;
    ProfileAbstract customer;
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    public OpenNewAccount() {
        super();
        customer = new CustomerProfile();
        getOpenNewAccountFormFieldMap();
        formActionCommandMap = new LinkedHashMap<>();
        formActionCommandMap.put(1, new EditFormCommand("Edit", customer, openNewAccountFormFieldMap));
        formActionCommandMap.put(2, new SaveOpenNewAccountFormCommand("Save", customer));
        formActionCommandMap.put(3, new BackToMainMenuCommand("Back to main menu"));
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

        Iterator<Map.Entry<Integer,IFormCommand>> iterator = openNewAccountFormFieldMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer,IFormCommand> formQuestionEntry = iterator.next();
           IFormCommand formCommand = formQuestionEntry.getValue();
            formCommand.execute();
        }


        while (loggedInUserContext.checkCurrentPageStatus(menuLabel)) {
            int key = 1;
            for (int i = 0; i < formActionCommandMap.size(); i++) {
               IFormCommand formState = formActionCommandMap.get(key);
                System.out.println(key + ". " + formState.getCommandLabel());
                key = key + 1;
            }
            String action = userInterface.getMandatoryIntegerUserInput("Enter any Number between 1-" + formActionCommandMap.size() + " to perform appropriate action:");

           IFormCommand formCommand = formActionCommandMap.get(Integer.parseInt(action));
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
        openNewAccountFormFieldMap.put(7, new PostalCodeCommand(customer));
        openNewAccountFormFieldMap.put(8, new ProvinceCommand(customer));
        openNewAccountFormFieldMap.put(9, new ContactCommand(customer));
        openNewAccountFormFieldMap.put(10, new EmailCommand(customer));
        openNewAccountFormFieldMap.put(11, new PassPortNumberCommand(customer));
        openNewAccountFormFieldMap.put(12, new SSNNumberCommand(customer));
        openNewAccountFormFieldMap.put(13, new DOBCommand(customer));
    }

}
