package PresentationLayer.Pages.CommonPages;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IAbstractFormCommand;
import BusinessLogicLayer.User.AbstractProfile;

import java.util.Map;

public interface ICommonPagesFactory {
    ILoginPage createLogin();

    IUserFormPage createUserForm(Map<Integer, IAbstractFormCommand> formFields, AbstractProfile profile);

    IUserFormPage createUserForm(Map<Integer, IAbstractFormCommand> formFields, AbstractProfile profile, String currentPage);

    IUserFormPage createUserForm(Map<Integer, IAbstractFormCommand> formFields);

    IUserInterfacePage createUserInterface();
}
