package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.BankEmployeeProfile;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.ProfileDatabase.IEmployeeProfileDatabase;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;

public class SaveNewEmployeeProfileFormActionCommand extends FormCommand {
    private static final String COMMAND_LABEL = "Save";
    private static final String COMMAND_TYPE = "ACTION";

    private IUserProfileDatabase userProfileDatabase;
    private IEmployeeProfileDatabase employeeProfileDatabase;

    public SaveNewEmployeeProfileFormActionCommand(BankEmployeeProfile bankEmployeeProfile) {
        super();
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
        return COMMAND_TYPE;
    }


    private int createNewEmployee() {
        databaseFactory = new DatabaseFactory();
        int affectedRows = employeeProfileDatabase.addNewBankEmployeeProfile(profile);
        return affectedRows;
    }


    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }

}

