package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.BankAction.FormActionCommands.BackToMainMenuCommand;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CustomerAction.FormCommands.*;
import BusinessLogicLayer.User.ProfileAbstract;
import DataAccessLayer.*;
import PresentationLayer.MenuPages.IUserForm;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UpdatePersonalDetails extends Action {
    private static final String menuLabel = "Update Personal Details";
    private Map<Integer,IFormCommand> formFields;

    public UpdatePersonalDetails() {
        this.databaseFactory = new DatabaseFactory();
        formFields = new HashMap<>();
    }

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    public void performAction() {
        isUpdated = false;
        userInterface.displayMessage("============UPDATE PERSONAL DETAILS=====================");
        String currentUserAccountNumber = loggedInUserContext.getAccountNumber();
        setCurrentPageInContext();
        userInterface.displayMessage("Update Personal Details");
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        ICustomerDatabase customerDatabase = databaseFactory.createCustomerDatabase();
        try {
            ProfileAbstract profileAbstract = customerDatabase.getUser(currentUserAccountNumber);
            IUserForm userForm = presentationFactory.createUserForm(getFormFields(profileAbstract), profileAbstract, loggedInUserContext.getCurrentPage());
            userForm.executeForm();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Map<Integer,IFormCommand> getFormFields(ProfileAbstract profileAbstract) {
        formFields.put(1, new FirstNameCommand(profileAbstract));
        formFields.put(2, new MiddleNameCommand(profileAbstract));
        formFields.put(3, new LastNameCommand(profileAbstract));
        formFields.put(4, new AddressLine1Command(profileAbstract));
        formFields.put(5, new AddressLine2Command(profileAbstract));
        formFields.put(6, new CityCommand(profileAbstract));
        formFields.put(7, new ProvinceCommand(profileAbstract));
        formFields.put(8, new ContactCommand(profileAbstract));
        formFields.put(9, new EmailCommand(profileAbstract));
        formFields.put(10, new PassPortNumberCommand(profileAbstract));
        formFields.put(11, new SSNNumberCommand(profileAbstract));
        formFields.put(12, new DOBCommand(profileAbstract));
        formFields.put(13, new SaveFormCommand(profileAbstract));
        formFields.put(14, new BackToMainMenuCommand("Back to main menu"));

        return formFields;
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }
}
