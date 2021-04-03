package PresentationLayer.MenuPages;

import BusinessLogicLayer.CustomerAction.FormCommands.*;
import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.ProfileAbstract;

import java.util.Map;

public class UserForm implements IUserForm {
    private Map<Integer,IFormCommand> formFields;
    private ProfileAbstract profileAbstract;
    private IPage formPage;

    public UserForm(Map<Integer,IFormCommand> formFields) {
        this.formFields = formFields;
        this.profileAbstract = new CustomerProfile();
    }

    public UserForm(Map<Integer,IFormCommand> formFields, ProfileAbstract profileAbstract) {
        this.profileAbstract = profileAbstract;
        this.formFields = formFields;
        formPage = new FormPage(formFields, "");
    }

    public UserForm(Map<Integer,IFormCommand> formFields, ProfileAbstract profileAbstract, String currentPage) {
        this.profileAbstract = profileAbstract;
        this.formFields = formFields;
        formPage = new FormPage(formFields, currentPage);
    }

    public ProfileAbstract getUser() {
        return profileAbstract;
    }

    public void setUser(ProfileAbstract profileAbstract) {
        this.profileAbstract = profileAbstract;
    }

    @Override
    public void executeForm() {
        formPage.printMenu();
    }

}
