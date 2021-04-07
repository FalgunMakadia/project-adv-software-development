package BusinessLogicLayer.ProfileForm.CommonProfileForm;

import BusinessLogicLayer.User.*;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;
import DataAccessLayer.OperationDatabase.IWorklistOperationDatabase;
import PresentationLayer.Pages.CommonPages.ICommonPagesFactory;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.PresentationFactory;

public abstract class FormCommand implements IFormCommand {
    protected AbstractProfile profile;
    protected IUserInterfacePage userInterface;
    protected IWorklistOperationDatabase workListOperationDatabase;
    protected DatabaseFactory databaseFactory;
    protected ILoggedInUserContext loggedInUserContext;
    protected IPresentationFactory presentationFactory;
    protected ICommonPagesFactory commonPagesFactory;
    protected IOperationDatabaseFactory operationDatabaseFactory;
    protected IUserFactory userFactory;

    public FormCommand(AbstractProfile profile) {
        this.profile = profile;
        init();
    }

    public FormCommand() {
        init();
    }

    private void init() {
        presentationFactory = new PresentationFactory();
        commonPagesFactory = presentationFactory.createCommonPagesFactory();

        this.databaseFactory = new DatabaseFactory();
        this.operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        this.workListOperationDatabase = operationDatabaseFactory.createWorkListOperationDatabase();

        this.userInterface = commonPagesFactory.createUserInterface();
        this.loggedInUserContext = LoggedInUserContext.instance();
    }
}
