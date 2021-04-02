package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.Customer;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import BusinessLogicLayer.User.User;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IWorklistDatabase;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.PresentationFactory;

public abstract class FormCommand {
    protected User user;
    protected IUserInterface userInterface;
    protected IWorklistDatabase worklistDatabase;
    protected DatabaseFactory databaseFactory;
    protected ILoggedInUserContext loggedInUserContext;

    public FormCommand(User user) {
        this.user = user;
        init();
    }

    public FormCommand() {
        this.user = new Customer();
        init();
    }

    private void init() {
        IPresentationFactory presentationFactory = new PresentationFactory();
        this.databaseFactory = new DatabaseFactory();
        this.userInterface = presentationFactory.createUserInterface();
        this.worklistDatabase = databaseFactory.createWorkListDatabase();
        this.loggedInUserContext = LoggedInUserContext.instance();
    }

    public abstract void execute();

    public abstract String getFieldValue();

    public abstract String getCommandLabel();
}
