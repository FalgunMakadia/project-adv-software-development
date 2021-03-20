package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class OpenNewAccount extends Action {
    IDatabaseFactory databaseFactory;
    private static final String menuLabel = "Open New Account";
    Map<Integer, FormState> openNewAccountStateMap;
    OpenNewAccountStateContext openNewAccountStateContext;
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    public OpenNewAccount() {
        super();
        databaseFactory = new DatabaseFactory();
        openNewAccountStateMap = new LinkedHashMap<>();
        openNewAccountStateMap.put(1, new OpenNewAccountFormEditState("Refill the form"));
        openNewAccountStateMap.put(2, new OpenNewAccountFormSaveState("Save"));
        openNewAccountStateMap.put(3, new BackToMainMenuState("Back to main menu"));
        openNewAccountStateContext =new OpenNewAccountStateContext();
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
        openNewAccountStateContext.setOpenNewAccountState(new OpenNewAccountFormEditState());
        openNewAccountStateContext.executeStateTask();

        while(loggedInUserContext.checkCurrentPageStatus(menuLabel)) {
            int key = 1;
            for (int i = 0; i < openNewAccountStateMap.size(); i++) {
                FormState formState = openNewAccountStateMap.get(key);
                System.out.println(key + ". " + formState.getMenuLabel());
                key = key + 1;
            }
            String action = userInterface.getMandatoryIntegerUserInput("Enter any Number between 1-" + openNewAccountStateMap.size() + " to perform appropriate action:");

            FormState newState = openNewAccountStateMap.get(Integer.parseInt(action));
            openNewAccountStateContext.setOpenNewAccountState(newState);
            userInterface.displayMessage(newState.getMenuLabel());
            openNewAccountStateContext.executeStateTask();
        }
    }


}
