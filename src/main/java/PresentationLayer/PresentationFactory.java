package PresentationLayer;

public class PresentationFactory implements IPresentationFactory{
    @Override
    public IUserInterface createUserInterface() {
        return new UserInterface();
    }
}
