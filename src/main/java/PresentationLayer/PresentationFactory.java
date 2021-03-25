package PresentationLayer;

import BusinessLogicLayer.User.User;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.CommonPages.UserInterface;
import PresentationLayer.MenuPages.Command;
import PresentationLayer.MenuPages.ExistingBankAccountCommand;
import PresentationLayer.MenuPages.IUserForm;
import PresentationLayer.MenuPages.UserForm;

public class PresentationFactory implements IPresentationFactory{
    @Override
    public IUserInterface createUserInterface() {
        return new UserInterface();
    }

    @Override
    public Command createExistingBankAccountCommand() {
        return new ExistingBankAccountCommand();
    }

    @Override
    public IUserForm createUserForm(User user) {
        return new UserForm(user);
    }

    @Override
    public IUserForm createUserForm() {
        return new UserForm();
    }
}
