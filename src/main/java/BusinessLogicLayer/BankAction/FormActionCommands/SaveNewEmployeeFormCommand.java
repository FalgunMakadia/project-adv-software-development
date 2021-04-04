package BusinessLogicLayer.BankAction.FormActionCommands;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.User.BankEmployeeProfile;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IEmployeeProfileDatabase;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;

public class SaveNewEmployeeFormCommand extends FormCommand {
    private final String menuLabel;
    private IUserProfileDatabase userProfileDatabase;
    private IEmployeeProfileDatabase employeeProfileDatabase;

    public SaveNewEmployeeFormCommand(String menuLabel, BankEmployeeProfile bankEmployeeProfile) {
        super();
        this.menuLabel = menuLabel;
        this.profile = bankEmployeeProfile;
        IProfileDatabaseFactory profileDatabaseFactory = databaseFactory.createProfileDatabaseFactory();
        userProfileDatabase = profileDatabaseFactory.createUserProfileDatabase();
        employeeProfileDatabase = profileDatabaseFactory.createEmployeeProfileDatabase();
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

        IUserProfileDatabase userDatabase = null;
        userProfileDatabase.addNewUser(userName, defaultPassword, profile.getProfileRole());

    }


    @Override
    public String getFieldValue() {
        return null;
    }


    private int createNewEmployee() {
        databaseFactory = new DatabaseFactory();
        int affectedRows = employeeProfileDatabase.addNewBankEmployeeProfile(profile);
        return affectedRows;
    }


    @Override
    public String getCommandLabel() {
        return menuLabel;
    }

}

