package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import BusinessLogicLayer.User.ProfileAbstract;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IWorklistDatabase;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.PresentationFactory;

public abstract class FormCommand {
    protected ProfileAbstract profile;
    protected IUserInterface userInterface;
    protected IWorklistDatabase worklistDatabase;
    protected DatabaseFactory databaseFactory;
    protected ILoggedInUserContext loggedInUserContext;

    public FormCommand(ProfileAbstract profile) {
        this.profile = profile;
        init();
    }

    public FormCommand() {
        this.profile = new CustomerProfile();
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
