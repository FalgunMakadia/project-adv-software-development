package PresentationLayer;

import PresentationLayer.CommonPages.IUserInterface;

public interface IPresentationFactory {
    IUserInterface createUserInterface();
}
