package PresentationLayer.Pages.CommonPages;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IFormCommand;
import BusinessLogicLayer.User.AbstractProfile;

import java.util.Map;

public class CommonPagesFactory implements ICommonPagesFactory {
    @Override
    public ILoginPage createLogin() {
        return new LoginPage();
    }

    @Override
    public IUserFormPage createUserForm(Map<Integer, IFormCommand> formFields, AbstractProfile profile) {
        return new UserFormPage(formFields, profile);
    }

    @Override
    public IUserFormPage createUserForm(Map<Integer,IFormCommand> formFields, AbstractProfile profile, String currentPage) {
        return new UserFormPage(formFields, profile, currentPage);
    }

    @Override
    public IUserFormPage createUserForm(Map<Integer, IFormCommand> formFields) {
        return new UserFormPage(formFields);
    }

    @Override
    public IUserInterfacePage createUserInterface() {
        return new UserInterfacePage();
    }

}
