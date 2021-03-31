package PresentationLayer.MenuPages;

import BusinessLogicLayer.CustomerAction.FormCommands.*;
import BusinessLogicLayer.User.Customer;
import BusinessLogicLayer.User.User;

import java.util.HashMap;
import java.util.Map;

public class UserForm implements IUserForm {
    private Map<Integer, FormCommand> formFields;
    private User user;
    private Page formPage;

    public UserForm(Map<Integer, FormCommand> formFields) {
        this.formFields = formFields;
        this.user = new Customer();
    }

    public UserForm(Map<Integer, FormCommand> formFields, User user) {
        this.user = user;
        this.formFields = formFields;
        formPage = new FormPage(formFields, "");
    }

    public UserForm(Map<Integer, FormCommand> formFields, User user, String currentPage) {
        this.user = user;
        this.formFields = formFields;
        formPage = new FormPage(formFields, currentPage);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void executeForm() {
        formPage.printMenu();
    }

}
