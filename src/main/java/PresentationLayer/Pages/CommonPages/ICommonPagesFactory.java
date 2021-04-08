package PresentationLayer.Pages.CommonPages;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IFormCommand;
import BusinessLogicLayer.User.AbstractProfile;

import java.util.Map;

public interface ICommonPagesFactory {
    ILoginPage createLogin();

    IUserFormPage createUserForm(Map<Integer, IFormCommand> formFields, AbstractProfile profile);

    IUserFormPage createUserForm(Map<Integer, IFormCommand> formFields, AbstractProfile profile, String currentPage);

    IUserInterfacePage createUserInterface();
}
