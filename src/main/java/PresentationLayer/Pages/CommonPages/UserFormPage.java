package PresentationLayer.Pages.CommonPages;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IAbstractFormCommand;
import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.IPage;

import java.util.Map;

public class UserFormPage implements IUserFormPage {
    private Map<Integer, IAbstractFormCommand> formFields;
    private AbstractProfile profile;
    private IPage formPage;

    public UserFormPage(Map<Integer, IAbstractFormCommand> formFields) {
        this.formFields = formFields;
        this.profile = new CustomerProfile();
    }

    public UserFormPage(Map<Integer, IAbstractFormCommand> formFields, AbstractProfile profile) {
        this.profile = profile;
        this.formFields = formFields;
        formPage = new FormPage(formFields, "");
    }

    public UserFormPage(Map<Integer, IAbstractFormCommand> formFields, AbstractProfile profile, String currentPage) {
        this.profile = profile;
        this.formFields = formFields;
        formPage = new FormPage(formFields, currentPage);
    }

    public AbstractProfile getUser() {
        return profile;
    }

    public void setUser(AbstractProfile profile) {
        this.profile = profile;
    }

    @Override
    public void printForm() {
        formPage.printPage();
    }

}
