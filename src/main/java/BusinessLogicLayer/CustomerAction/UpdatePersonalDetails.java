package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IFormCommand;
import BusinessLogicLayer.ProfileForm.CommonProfileForm.IProfileFormFactory;
import BusinessLogicLayer.ProfileForm.CommonProfileForm.ProfileFormFactory;
import BusinessLogicLayer.ProfileForm.ProfileFormAction.BackToMainMenuProfileFormActionCommand;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.ProfileForm.ProfileFormAction.SaveUpdatedPersonalDetailFormActionCommand;
import BusinessLogicLayer.ProfileForm.ProfileFormFields.*;
import BusinessLogicLayer.User.ProfileAbstract;
import DataAccessLayer.ProfileDatabase.ICustomerProfileDatabase;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import PresentationLayer.Pages.CommonPages.IUserFormPage;

import java.util.HashMap;
import java.util.Map;

public class UpdatePersonalDetails extends Action {
    private static final String menuLabel = "Update Personal Details";
    private Map<Integer, IFormCommand> formFields;
    private ICustomerProfileDatabase customerProfileDatabase;

    public UpdatePersonalDetails() {
        formFields = new HashMap<>();

        IProfileDatabaseFactory profileDatabaseFactory = databaseFactory.createProfileDatabaseFactory();
        customerProfileDatabase = profileDatabaseFactory.createCustomerProfileDatabase();
    }

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    public void performAction() {
        userInterface.displayMessage("============UPDATE PERSONAL DETAILS=====================");
        String currentUserAccountNumber = loggedInUserContext.getAccountNumber();
        setCurrentPageInContext();
        userInterface.displayMessage("Update Personal Details");

        ProfileAbstract profile = customerProfileDatabase.getCustomerProfile(currentUserAccountNumber);
        IUserFormPage userForm = commonPagesFactory.createUserForm(getFormFields(profile), profile, loggedInUserContext.getCurrentPage());
        userForm.printForm();
    }

    private Map<Integer, IFormCommand> getFormFields(ProfileAbstract profile) {
        IProfileFormFactory profileFormFactory =new ProfileFormFactory();

        formFields.put(1, profileFormFactory.createFirstNameFieldCommand(profile));
        formFields.put(2, profileFormFactory.createMiddleNameFieldCommand(profile));
        formFields.put(3, profileFormFactory.createLastNameFieldCommand(profile));
        formFields.put(4, profileFormFactory.createAddressLine1FieldCommand(profile));
        formFields.put(5, profileFormFactory.createAddressLine2FieldCommand(profile));
        formFields.put(6, profileFormFactory.createCityFieldCommand(profile));
        formFields.put(7, profileFormFactory.createProvinceFieldCommand(profile));
        formFields.put(8, profileFormFactory.createContactFieldCommand(profile));
        formFields.put(9, profileFormFactory.createEmailFieldCommand(profile));
        formFields.put(10, profileFormFactory.createPassPortNumberFieldCommand(profile));
        formFields.put(11, profileFormFactory.createSsnNumberFieldCommand(profile));
        formFields.put(12, profileFormFactory.createDateOfBirthFieldCommand(profile));
        formFields.put(13, profileFormFactory.createSaveUpdatedPersonalDetailFormActionCommand(profile));
        formFields.put(14, profileFormFactory.createBackToMainMenuProfileFormActionCommand("Back to main menu"));

        return formFields;
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }
}
