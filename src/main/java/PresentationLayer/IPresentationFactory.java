package PresentationLayer;

import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.MenuPages.Command;

public interface IPresentationFactory {
    IUserInterface createUserInterface();
    Command createExistingBankAccountCommand();
}
