package BusinessLogicLayer.BankAction.FormActionCommands;

import java.io.IOException;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.User.BankEmployeeProfile;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;
import DataAccessLayer.IEmployeeDatabase;
import DataAccessLayer.IUserDetailsDatabase;

public class SaveNewEmployeeFormCommand extends FormCommand {
    private final String menuLabel;
    private IDatabaseFactory databaseFactory;
    private IEmployeeDatabase employeeDatabase;

    public SaveNewEmployeeFormCommand(String menuLabel, BankEmployeeProfile bankEmployeeProfile) {
        super();
        this.menuLabel = menuLabel;
        this.profile = bankEmployeeProfile;
    }

    @Override
    public void execute() {
        //working on implementation
        try {
            createNewEmployee();
            userInterface.displayMessage("The employee details are saved ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        createNewUser();

    }

    private void createNewUser() {
        String userName = profile.getUserName();
        int defaultPassword = profile.generateDefaultPassword();

        IUserDetailsDatabase userDatabase = null;
        userDatabase = databaseFactory.createUserDatabase();
        userDatabase.insertNewUser(userName, defaultPassword, profile.getProfileRole());

    }


    @Override
    public String getFieldValue() {
        return null;
    }


    private void createNewEmployee() throws IOException {
        databaseFactory = new DatabaseFactory();
        employeeDatabase = databaseFactory.createNewEmployee();
        employeeDatabase.add(profile);

    }


    @Override
    public String getCommandLabel() {
        return menuLabel;
    }

}

