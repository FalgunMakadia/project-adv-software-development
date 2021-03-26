package PresentationLayer;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.User.User;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.MenuPages.Command;
import PresentationLayer.MenuPages.IUserForm;

import java.util.Map;

public interface IPresentationFactory {
    IUserInterface createUserInterface();
    Command createExistingBankAccountCommand();
    IUserForm createUserForm(Map<Integer, FormCommand> formFields, User user);
    IUserForm createUserForm(Map<Integer, FormCommand> formFields);
}
