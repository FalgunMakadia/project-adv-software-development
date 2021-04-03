package PresentationLayer.Pages.CommonPages;

import BusinessLogicLayer.CustomerAction.FormCommands.IFormCommand;
import BusinessLogicLayer.User.ProfileAbstract;

import java.util.Map;

public interface ICommonPagesFactory {
    ILoginPage createLogin();

    IUserFormPage createUserForm(Map<Integer, IFormCommand> formFields, ProfileAbstract profileAbstract);

    IUserFormPage createUserForm(Map<Integer, IFormCommand> formFields, ProfileAbstract profileAbstract, String currentPage);

    IUserFormPage createUserForm(Map<Integer, IFormCommand> formFields);

    IUserInterfacePage createUserInterface();
}
