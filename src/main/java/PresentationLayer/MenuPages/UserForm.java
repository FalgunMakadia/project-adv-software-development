package PresentationLayer.MenuPages;

import BusinessLogicLayer.CustomerAction.FormCommands.*;
import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.ProfileAbstract;

import java.util.Map;

public class UserForm implements IUserForm {
    private Map<Integer, FormCommand> formFields;
    private ProfileAbstract profileAbstract;
    private Page formPage;

    public UserForm(Map<Integer, FormCommand> formFields) {
        this.formFields = formFields;
        this.profileAbstract = new CustomerProfile();
    }

    public UserForm(Map<Integer, FormCommand> formFields, ProfileAbstract profileAbstract) {
        this.profileAbstract = profileAbstract;
        this.formFields = formFields;
        formPage = new FormPage(formFields, "");
    }

    public UserForm(Map<Integer, FormCommand> formFields, ProfileAbstract profileAbstract, String currentPage) {
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
