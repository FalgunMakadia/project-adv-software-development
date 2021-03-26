package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.BankAction.FormActionCommands.BackToMainMenuCommand;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CustomerAction.FormCommands.*;
import BusinessLogicLayer.User.User;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import DataAccessLayer.*;
import PresentationLayer.MenuPages.IUserForm;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UpdatePersonalDetails extends Action {
    private static final String menuLabel = "Update Personal Details";
    private IDatabaseFactory databaseFactory;
    private boolean isUpdated = false;
    private Map<Integer, FormCommand> formFields;

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
            User user = customerDatabase.getUser(currentUserAccountNumber);
            IUserForm userForm = presentationFactory.createUserForm(getFormFields(user), user, loggedInUserContext.getCurrentPage());
            userForm.executeForm();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Map<Integer, FormCommand> getFormFields(User user) {
        formFields.put(1, new FirstNameCommand(user));
        formFields.put(2, new MiddleNameCommand(user));
        formFields.put(3, new LastNameCommand(user));
        formFields.put(4, new AddressLine1Command(user));
        formFields.put(5, new AddressLine2Command(user));
        formFields.put(6, new CityCommand(user));
        formFields.put(7, new ProvinceCommand(user));
        formFields.put(8, new ContactCommand(user));
        formFields.put(9, new EmailCommand(user));
        formFields.put(10, new PassPortNumberCommand(user));
        formFields.put(11, new SSNNumberCommand(user));
        formFields.put(12, new DOBCommand(user));
        formFields.put(13, new SaveFormCommand(user));
        formFields.put(14, new BackToMainMenuCommand("Back to main menu"));

        return formFields;
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(menuLabel);
    }
}
