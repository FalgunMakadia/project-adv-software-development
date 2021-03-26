package PresentationLayer;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.User.User;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.CommonPages.UserInterface;
import PresentationLayer.MenuPages.Command;
import PresentationLayer.MenuPages.ExistingBankAccountCommand;
import PresentationLayer.MenuPages.IUserForm;
import PresentationLayer.MenuPages.UserForm;

import java.util.Map;

public class PresentationFactory implements IPresentationFactory {
    @Override
    public IUserInterface createUserInterface() {
        return new UserInterface();
    }

    @Override
    public Command createExistingBankAccountCommand() {
        return new ExistingBankAccountCommand();
    }

    @Override
    public IUserForm createUserForm(Map<Integer, FormCommand> formFields, User user) {
        return new UserForm(formFields, user);
    }

    @Override
    public IUserForm createUserForm(Map<Integer, FormCommand> formFields) {
        return new UserForm(formFields);
    }
}
