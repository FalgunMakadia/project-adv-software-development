package BusinessLogicLayer.ProfileForm.CommonProfileForm;

import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import BusinessLogicLayer.User.ProfileAbstract;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;
import DataAccessLayer.OperationDatabase.IWorklistOperationDatabase;
import PresentationLayer.Pages.CommonPages.ICommonPagesFactory;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.PresentationFactory;

public abstract class FormCommand implements IFormCommand {
    protected ProfileAbstract profile;
    protected IUserInterfacePage userInterface;
    protected IWorklistOperationDatabase worklistOperationDatabase;
    protected DatabaseFactory databaseFactory;
    protected ILoggedInUserContext loggedInUserContext;
    protected IPresentationFactory presentationFactory;
    protected ICommonPagesFactory commonPagesFactory;
    protected IOperationDatabaseFactory operationDatabaseFactory;

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
        this.operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        this.worklistOperationDatabase = operationDatabaseFactory.createWorkListOperationDatabase();

        this.userInterface = commonPagesFactory.createUserInterface();
        this.loggedInUserContext = LoggedInUserContext.instance();
    }
}
