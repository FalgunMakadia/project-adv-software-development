package PresentationLayer.Pages.CommonPages;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IFormCommand;
import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.ProfileAbstract;
import PresentationLayer.Pages.IPage;

import java.util.Map;

public class UserFormPage implements IUserFormPage {
    private Map<Integer, IFormCommand> formFields;
    private ProfileAbstract profileAbstract;
    private IPage formPage;

    public UserFormPage(Map<Integer,IFormCommand> formFields) {
        this.formFields = formFields;
        this.profileAbstract = new CustomerProfile();
    }

    public UserFormPage(Map<Integer,IFormCommand> formFields, ProfileAbstract profileAbstract) {
        this.profileAbstract = profileAbstract;
        this.formFields = formFields;
        formPage = new FormPage(formFields, "");
    }

    public UserFormPage(Map<Integer,IFormCommand> formFields, ProfileAbstract profileAbstract, String currentPage) {
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
    public void printForm() {
        formPage.printPage();
    }

}
