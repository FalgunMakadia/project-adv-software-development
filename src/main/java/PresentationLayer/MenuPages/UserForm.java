package PresentationLayer.MenuPages;

import BusinessLogicLayer.CustomerAction.FormCommands.*;
import BusinessLogicLayer.User.Customer;
import BusinessLogicLayer.User.User;

import java.util.HashMap;
import java.util.Map;

public class UserForm implements IUserForm {
    private Map<Integer, FormCommand> formFields;
    private User user;

    public UserForm() {
        this.user = new Customer();
        init();
    }

    public UserForm(User user) {
        this.user = user;
        init();
    }

    private void init() {
        formFields = new HashMap<>();
        formFields.put(1, new UpdateFirstName(this.user));
        formFields.put(2, new UpdateMiddleName(this.user));
        formFields.put(3, new UpdateLastName(this.user));
        formFields.put(4, new UpdateAddressLine1(this.user));
        formFields.put(5, new UpdateAddressLine2(this.user));
        formFields.put(6, new UpdateCity(this.user));
        formFields.put(7, new UpdateProvince(this.user));
        formFields.put(8, new UpdateContact(this.user));
        formFields.put(9, new UpdateEmail(this.user));
        formFields.put(10, new UpdatePassPortNumber(this.user));
        formFields.put(11, new UpdateSSNNumber(this.user));
        formFields.put(12, new UpdateDOB(this.user));
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
