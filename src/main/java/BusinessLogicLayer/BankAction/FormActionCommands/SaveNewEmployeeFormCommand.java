package BusinessLogicLayer.BankAction.FormActionCommands;

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
        int affectedRows = createNewEmployee();
        if (affectedRows > 0) {
            createNewUser();
            userInterface.displayMessage("The employee details are saved ");
        }
    }

    private void createNewUser() {
        String userName = profile.getUserName();
        String defaultPassword = String.valueOf(profile.generateDefaultPassword());

        IUserDetailsDatabase userDatabase = null;
        userDatabase = databaseFactory.createUserDatabase();
        userDatabase.addNewUser(userName, defaultPassword, profile.getProfileRole());

    }


    @Override
    public String getFieldValue() {
        return null;
    }


    private int createNewEmployee() {
        databaseFactory = new DatabaseFactory();
        employeeDatabase = databaseFactory.createNewEmployee();
        int affectedRows = employeeDatabase.addNewBankEmployeeProfile(profile);
        return affectedRows;
    }


    @Override
    public String getCommandLabel() {
        return menuLabel;
    }

}

