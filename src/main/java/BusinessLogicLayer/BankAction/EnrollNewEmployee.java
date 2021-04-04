package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IFormCommand;
import BusinessLogicLayer.ProfileForm.CommonProfileForm.IProfileFormFactory;
import BusinessLogicLayer.ProfileForm.CommonProfileForm.ProfileFormFactory;
import BusinessLogicLayer.ProfileForm.ProfileFormAction.BackToMainMenuProfileFormActionCommand;
import BusinessLogicLayer.ProfileForm.ProfileFormAction.EditProfileFormActionCommand;
import BusinessLogicLayer.ProfileForm.ProfileFormFields.*;
import BusinessLogicLayer.ProfileForm.ProfileFormAction.SaveNewEmployeeProfileFormActionCommand;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.User.BankEmployeeProfile;

import java.util.LinkedHashMap;
import java.util.Map;

public class EnrollNewEmployee extends Action {
    private static final String menuLabel = "Enroll New Employee";
    Map<Integer, IFormCommand> formActionCommandMap;
    private Map<Integer, IFormCommand> openNewAccountFormFieldMap;
    BankEmployeeProfile bankEmployeeProfile;
    IProfileFormFactory profileFormFactory;
    public EnrollNewEmployee() {
        super();
        profileFormFactory = new ProfileFormFactory();
        bankEmployeeProfile = new BankEmployeeProfile();
        getOpenNewAccountFormFieldMap();
        formActionCommandMap = new LinkedHashMap<>();
        formActionCommandMap.put(1, profileFormFactory.createEditProfileFormActionCommand("Edit", bankEmployeeProfile, openNewAccountFormFieldMap));
        formActionCommandMap.put(2, profileFormFactory.createSaveNewEmployeeProfileFormActionCommand("Save", bankEmployeeProfile));
        formActionCommandMap.put(3, profileFormFactory.createBackToMainMenuProfileFormActionCommand("Back to main menu"));
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

        for (Map.Entry<Integer, IFormCommand> formQuestionEntry : openNewAccountFormFieldMap.entrySet()) {
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
        openNewAccountFormFieldMap.put(1, profileFormFactory.createFirstNameFieldCommand(bankEmployeeProfile));
        openNewAccountFormFieldMap.put(2, profileFormFactory.createMiddleNameFieldCommand(bankEmployeeProfile));
        openNewAccountFormFieldMap.put(3, profileFormFactory.createLastNameFieldCommand(bankEmployeeProfile));
        openNewAccountFormFieldMap.put(4, profileFormFactory.createAddressLine1FieldCommand(bankEmployeeProfile));
        openNewAccountFormFieldMap.put(5, profileFormFactory.createAddressLine2FieldCommand(bankEmployeeProfile));
        openNewAccountFormFieldMap.put(6, profileFormFactory.createCityFieldCommand(bankEmployeeProfile));
        openNewAccountFormFieldMap.put(7, profileFormFactory.createProvinceFieldCommand(bankEmployeeProfile));
        openNewAccountFormFieldMap.put(8, profileFormFactory.createContactFieldCommand(bankEmployeeProfile));
        openNewAccountFormFieldMap.put(9, profileFormFactory.createEmailFieldCommand(bankEmployeeProfile));
        openNewAccountFormFieldMap.put(10, profileFormFactory.createPassPortNumberFieldCommand(bankEmployeeProfile));
        openNewAccountFormFieldMap.put(11, profileFormFactory.createSsnNumberFieldCommand(bankEmployeeProfile));
        openNewAccountFormFieldMap.put(12, profileFormFactory.createDateOfBirthFieldCommand(bankEmployeeProfile));
    }

}
