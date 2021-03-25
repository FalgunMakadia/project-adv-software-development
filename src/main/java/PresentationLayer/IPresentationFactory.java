package PresentationLayer;

import BusinessLogicLayer.User.User;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.MenuPages.Command;
import PresentationLayer.MenuPages.IUserForm;

public interface IPresentationFactory {
    IUserInterface createUserInterface();
    Command createExistingBankAccountCommand();
    IUserForm createUserForm(User user);
    IUserForm createUserForm();
}
