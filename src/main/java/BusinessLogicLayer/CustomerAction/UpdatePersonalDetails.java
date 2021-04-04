package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.BankAction.FormActionCommands.BackToMainMenuCommand;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CustomerAction.FormCommands.*;
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
        formFields.put(1, new FirstNameCommand(profile));
        formFields.put(2, new MiddleNameCommand(profile));
        formFields.put(3, new LastNameCommand(profile));
        formFields.put(4, new AddressLine1Command(profile));
        formFields.put(5, new AddressLine2Command(profile));
        formFields.put(6, new CityCommand(profile));
        formFields.put(7, new ProvinceCommand(profile));
        formFields.put(8, new ContactCommand(profile));
        formFields.put(9, new EmailCommand(profile));
        formFields.put(10, new PassPortNumberCommand(profile));
        formFields.put(11, new SSNNumberCommand(profile));
        formFields.put(12, new DOBCommand(profile));
        formFields.put(13, new SaveFormCommand(profile));
        formFields.put(14, new BackToMainMenuCommand("Back to main menu"));

        return formFields;
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }
}
