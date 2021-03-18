package PresentationLayer;

import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.CommonPages.UserInterface;

public class PresentationFactory implements IPresentationFactory{
    @Override
    public IUserInterface createUserInterface() {
        return new UserInterface();
    }
}
