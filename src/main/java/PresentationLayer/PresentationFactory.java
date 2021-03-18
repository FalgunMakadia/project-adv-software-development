package PresentationLayer;

import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.CommonPages.UserInterface;
import PresentationLayer.MenuPages.Command;
import PresentationLayer.MenuPages.ExistingBankAccountCommand;

public class PresentationFactory implements IPresentationFactory{
    @Override
    public IUserInterface createUserInterface() {
        return new UserInterface();
    }

    @Override
    public Command createExistingBankAccountCommand() {
        return new ExistingBankAccountCommand();
    }
}
