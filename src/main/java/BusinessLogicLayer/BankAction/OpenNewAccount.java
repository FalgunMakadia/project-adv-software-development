package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IFormCommand;
import BusinessLogicLayer.ProfileForm.CommonProfileForm.IProfileFormFactory;
import BusinessLogicLayer.ProfileForm.CommonProfileForm.ProfileFormFactory;
import BusinessLogicLayer.ProfileForm.ProfileFormAction.BackToMainMenuProfileFormActionCommand;
import BusinessLogicLayer.ProfileForm.ProfileFormAction.EditProfileFormActionCommand;
import BusinessLogicLayer.ProfileForm.ProfileFormFields.*;
import BusinessLogicLayer.ProfileForm.ProfileFormAction.SaveNewAccountProfileFormActionCommand;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.ProfileAbstract;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class OpenNewAccount extends Action {
    private static final String menuLabel = "Open New Account";
    Map<Integer, IFormCommand> formActionCommandMap;
    private Map<Integer,IFormCommand> openNewAccountFormFieldMap;
    ProfileAbstract customer;
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    IProfileFormFactory profileFormFactory;
    public OpenNewAccount() {
        super();
        profileFormFactory =new ProfileFormFactory();
        customer = new CustomerProfile();
        getOpenNewAccountFormFieldMap();
        formActionCommandMap = new LinkedHashMap<>();
        formActionCommandMap.put(1, profileFormFactory.createEditProfileFormActionCommand("Edit", customer, openNewAccountFormFieldMap));
        formActionCommandMap.put(2, profileFormFactory.createSaveNewAccountProfileFormActionCommand("Save", customer));
        formActionCommandMap.put(3, profileFormFactory.createBackToMainMenuProfileFormActionCommand("Back to main menu"));
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
        openNewAccountFormFieldMap.put(1, profileFormFactory.createFirstNameFieldCommand(customer));
        openNewAccountFormFieldMap.put(2, profileFormFactory.createMiddleNameFieldCommand(customer));
        openNewAccountFormFieldMap.put(3, profileFormFactory.createLastNameFieldCommand(customer));
        openNewAccountFormFieldMap.put(4, profileFormFactory.createAddressLine1FieldCommand(customer));
        openNewAccountFormFieldMap.put(5, profileFormFactory.createAddressLine2FieldCommand(customer));
        openNewAccountFormFieldMap.put(6, profileFormFactory.createCityFieldCommand(customer));
        openNewAccountFormFieldMap.put(7, profileFormFactory.createPostalCodeFieldCommand(customer));
        openNewAccountFormFieldMap.put(8, profileFormFactory.createProvinceFieldCommand(customer));
        openNewAccountFormFieldMap.put(9, profileFormFactory.createContactFieldCommand(customer));
        openNewAccountFormFieldMap.put(10, profileFormFactory.createEmailFieldCommand(customer));
        openNewAccountFormFieldMap.put(11, profileFormFactory.createPassPortNumberFieldCommand(customer));
        openNewAccountFormFieldMap.put(12, profileFormFactory.createSsnNumberFieldCommand(customer));
        openNewAccountFormFieldMap.put(13, profileFormFactory.createDateOfBirthFieldCommand(customer));
    }

}
