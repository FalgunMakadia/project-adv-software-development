package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import BusinessLogicLayer.User.ProfileAbstract;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IWorklistDatabase;
import PresentationLayer.Pages.CommonPages.ICommonPagesFactory;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.PresentationFactory;

public abstract class FormCommand implements IFormCommand {
    protected ProfileAbstract profile;
    protected IUserInterfacePage userInterface;
    protected IWorklistDatabase worklistDatabase;
    protected DatabaseFactory databaseFactory;
    protected ILoggedInUserContext loggedInUserContext;
    protected IPresentationFactory presentationFactory;
    protected ICommonPagesFactory commonPagesFactory;

    public FormCommand(ProfileAbstract profile) {
        this.profile = profile;
        init();
    }

    public FormCommand() {
        this.profile = new CustomerProfile();
        init();
    }

    private void init() {
        presentationFactory = new PresentationFactory();
        commonPagesFactory = presentationFactory.createCommonPagesFactory();

        this.databaseFactory = new DatabaseFactory();
        this.userInterface = commonPagesFactory.createUserInterface();
        this.worklistDatabase = databaseFactory.createWorkListDatabase();
        this.loggedInUserContext = LoggedInUserContext.instance();
    }
}
