package BusinessLogicLayer.BankAction.FormActionCommands;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.User.User;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import DataAccessLayer.IDatabaseFactory;
import DataAccessLayer.IUserDetailsDatabase;

import java.io.IOException;
import java.sql.SQLException;

public class SaveOpenNewAccountFormCommand extends FormCommand {
    private String menuLabel;
    private IDatabaseFactory databaseFactory;
    User user;

    public SaveOpenNewAccountFormCommand(String menuLabel, User user) {
        super();
        this.menuLabel = menuLabel;
        this.user = user;
    }

    @Override
    public void execute() {

        //createNewUser();
        createNewWorkListRequest();
        loggedInUserContext.setCurrentPage("");
    }

    @Override
    public String getFieldValue() {
        return null;
    }

    private void createNewWorkListRequest() {
        try {
            WorklistRequest worklistRequest = new WorklistRequest();
            worklistRequest.setRequestType("Open New Account");
            worklistRequest.setUser(user);
            worklistDatabase.addWorkListRequest(worklistRequest);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void createNewUser() {
        String userName = user.getUserName();
        int defaultPassword = user.generateDefaultPassword();
        IUserDetailsDatabase userDatabase = null;
        try {
            userDatabase = databaseFactory.createUserDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userDatabase.insertNewUser(userName, defaultPassword, "C");

    }

    @Override
    public String getCommandLabel() {
        return menuLabel;
    }

}
