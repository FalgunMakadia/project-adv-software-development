package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.Customer;
import BusinessLogicLayer.User.User;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.PresentationFactory;

public abstract class FormCommand {
    protected User user;
    protected IUserInterface userInterface;
    public FormCommand(User user) {
        IPresentationFactory presentationFactory = new PresentationFactory();
        this.user = user;
        this.userInterface = presentationFactory.createUserInterface();
    }

    public abstract void execute();

    public abstract String getFieldValue();

    public abstract String getLabel();
}
