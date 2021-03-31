package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.BankAction.FormActionCommands.BackToMainMenuCommand;
import BusinessLogicLayer.BankAction.FormActionCommands.EditFormCommand;
import BusinessLogicLayer.BankAction.FormActionCommands.SaveOpenNewAccountFormCommand;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CustomerAction.FormCommands.*;
import BusinessLogicLayer.User.BankEmployee;

import java.util.LinkedHashMap;
import java.util.Map;

public class EnrollNewEmployee extends Action {
    private static final String menuLabel = "Enroll New Employee";
    Map<Integer, FormCommand> formActionCommandMap;
    private Map<Integer, FormCommand> openNewAccountFormFieldMap;
    BankEmployee bankEmployee;
    public EnrollNewEmployee() {
        super();
        bankEmployee = new BankEmployee();
        getOpenNewAccountFormFieldMap();
        formActionCommandMap = new LinkedHashMap<>();
        formActionCommandMap.put(1, new EditFormCommand("Edit", bankEmployee, openNewAccountFormFieldMap));
        formActionCommandMap.put(2, new SaveOpenNewAccountFormCommand("Save", bankEmployee));
        formActionCommandMap.put(3, new BackToMainMenuCommand("Back to main menu"));
    }

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }

    @Override
    public void performAction() {
        setCurrentPageInContext();
        userInterface.displayMessage("Please enter the details of following fields:");
        userInterface.displayMessage("Note: (*) are mandatory fields.");
        userInterface.insertEmptyLine();

        for (Map.Entry<Integer, FormCommand> formQuestionEntry : openNewAccountFormFieldMap.entrySet()) {
            FormCommand formCommand = formQuestionEntry.getValue();
            formCommand.execute();
        }


        while (loggedInUserContext.checkCurrentPageStatus(menuLabel)) {
            int key = 1;
            for (int i = 0; i < formActionCommandMap.size(); i++) {
                FormCommand formState = formActionCommandMap.get(key);
                System.out.println(key + ". " + formState.getCommandLabel());
                key = key + 1;
            }
            String action = userInterface.getMandatoryIntegerUserInput("Enter any Number between 1-" + formActionCommandMap.size() + " to perform appropriate action:");

            FormCommand formCommand = formActionCommandMap.get(Integer.parseInt(action));
            formCommand.execute();

        }
    }

    private void getOpenNewAccountFormFieldMap() {
        openNewAccountFormFieldMap = new LinkedHashMap<>();
        openNewAccountFormFieldMap.put(1, new FirstNameCommand(bankEmployee));
        openNewAccountFormFieldMap.put(2, new MiddleNameCommand(bankEmployee));
        openNewAccountFormFieldMap.put(3, new LastNameCommand(bankEmployee));
        openNewAccountFormFieldMap.put(4, new AddressLine1Command(bankEmployee));
        openNewAccountFormFieldMap.put(5, new AddressLine2Command(bankEmployee));
        openNewAccountFormFieldMap.put(6, new CityCommand(bankEmployee));
        openNewAccountFormFieldMap.put(7, new ProvinceCommand(bankEmployee));
        openNewAccountFormFieldMap.put(8, new ContactCommand(bankEmployee));
        openNewAccountFormFieldMap.put(9, new EmailCommand(bankEmployee));
        openNewAccountFormFieldMap.put(10, new PassPortNumberCommand(bankEmployee));
        openNewAccountFormFieldMap.put(11, new SSNNumberCommand(bankEmployee));
        openNewAccountFormFieldMap.put(12, new DOBCommand(bankEmployee));
    }

}
