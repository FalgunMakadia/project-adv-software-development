package PresentationLayer.Pages.CommonPages;

import BusinessLogicLayer.CustomerAction.FormCommands.IFormCommand;
import BusinessLogicLayer.User.ProfileAbstract;

import java.util.Map;

public class CommonPagesFactory implements ICommonPagesFactory {
    @Override
    public ILoginPage createLogin() {
        return new LoginPage();
    }

    @Override
    public IUserFormPage createUserForm(Map<Integer, IFormCommand> formFields, ProfileAbstract profileAbstract) {
        return new UserFormPage(formFields, profileAbstract);
    }

    @Override
    public IUserFormPage createUserForm(Map<Integer,IFormCommand> formFields, ProfileAbstract profileAbstract, String currentPage) {
        return new UserFormPage(formFields, profileAbstract, currentPage);
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
