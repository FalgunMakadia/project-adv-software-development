package PresentationLayer.Pages.CommonPages;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IAbstractFormCommand;
import BusinessLogicLayer.User.AbstractProfile;

import java.util.Map;

public class CommonPagesFactory implements ICommonPagesFactory {
    @Override
    public ILoginPage createLogin() {
        return new LoginPage();
    }

    @Override
    public IUserFormPage createUserForm(Map<Integer, IAbstractFormCommand> formFields, AbstractProfile profile) {
        return new UserFormPage(formFields, profile);
    }

    @Override
    public IUserFormPage createUserForm(Map<Integer, IAbstractFormCommand> formFields, AbstractProfile profile, String currentPage) {
        return new UserFormPage(formFields, profile, currentPage);
    }

    @Override
    public IUserFormPage createUserForm(Map<Integer, IAbstractFormCommand> formFields) {
        return new UserFormPage(formFields);
    }

    @Override
    public IUserInterfacePage createUserInterface() {
        return new UserInterfacePage();
    }

}
