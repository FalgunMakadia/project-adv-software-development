package PresentationLayer.MenuPages;

import BusinessLogicLayer.CustomerAction.FormCommands.*;
import BusinessLogicLayer.User.Customer;
import BusinessLogicLayer.User.User;

import java.util.HashMap;
import java.util.Map;

public class UserForm implements IUserForm {
    private Map<Integer, FormCommand> formFields;
    private User user;
    private boolean saveUserDetails = false;

    public UserForm(Map<Integer, FormCommand> formFields) {
        this.formFields = formFields;
        this.user = new Customer();
    }

    public UserForm(Map<Integer, FormCommand> formFields,User user) {
        this.user = user;
        this.formFields = formFields;
    }

    private void init() {
        formFields = new HashMap<>();
        formFields.put(1, new FirstNameCommand());
        formFields.put(2, new MiddleNameCommand(this.user));
        formFields.put(3, new LastNameCommand(this.user));
        formFields.put(4, new AddressLine1Command(this.user));
        formFields.put(5, new AddressLine2Command(this.user));
        formFields.put(6, new CityCommand(this.user));
        formFields.put(7, new ProvinceCommand(this.user));
        formFields.put(8, new ContactCommand(this.user));
        formFields.put(9, new EmailCommand(this.user));
        formFields.put(10, new PassPortNumberCommand(this.user));
        formFields.put(11, new SSNNumberCommand(this.user));
        formFields.put(12, new DOBCommand(this.user));
        formFields.put(13, new SaveFormCommand(this.user));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void executeForm() {
        Page formPage = new FormPage(formFields, "Customer");
        formPage.printMenu();
    }
}
