package BusinessLogicLayer.BankAction.FormActionCommands;

import java.io.IOException;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.User.BankEmployee;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;
import DataAccessLayer.IEmployeeDatabase;
import DataAccessLayer.IUserDetailsDatabase;

public class SaveNewEmployeeFormCommand extends FormCommand {
    private final String menuLabel;
    private IDatabaseFactory databaseFactory;
    private IEmployeeDatabase employeeDatabase;
    BankEmployee bankEmployee;

    public SaveNewEmployeeFormCommand(String menuLabel, BankEmployee bankEmployee) {
        super();
        this.menuLabel = menuLabel;
        this.bankEmployee = bankEmployee;
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
        String userName = bankEmployee.getUserName();
        int defaultPassword = bankEmployee.generateDefaultPassword();
        String userRole="E";
        IUserDetailsDatabase userDatabase = null;
        try {
            userDatabase = databaseFactory.createUserDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userDatabase.insertNewUser(userName, defaultPassword,userRole);
       
    }


    

    @Override
    public String getFieldValue() {
        return null;
    }


    private void createNewEmployee() throws IOException {
        databaseFactory=new DatabaseFactory();
        employeeDatabase=databaseFactory.createNewEmployee();
        employeeDatabase.add(bankEmployee);
        
    }


    @Override
    public String getCommandLabel() {
        return menuLabel;
    }

}

