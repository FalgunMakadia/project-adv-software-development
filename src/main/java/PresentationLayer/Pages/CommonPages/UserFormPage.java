package PresentationLayer.Pages.CommonPages;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IAbstractFormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.IAbstractPage;

import java.util.Map;

public class UserFormPage implements IUserFormPage {

    private static final String EMPTY_STRING = "";

    private Map<Integer, IAbstractFormCommand> formFields;
    private AbstractProfile profile;
    private IAbstractPage formPage;

    public UserFormPage(Map<Integer, IAbstractFormCommand> formFields, AbstractProfile profile) {
        this.profile = profile;
        this.formFields = formFields;
        formPage = new FormPage(formFields, EMPTY_STRING);
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