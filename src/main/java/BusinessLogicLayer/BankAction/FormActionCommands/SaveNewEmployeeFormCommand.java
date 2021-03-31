package BusinessLogicLayer.BankAction.FormActionCommands;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.User.BankEmployee;
import DataAccessLayer.IDatabaseFactory;

public class SaveNewEmployeeFormCommand extends FormCommand {
    private final String menuLabel;
    private IDatabaseFactory databaseFactory;
    BankEmployee user;

    public SaveNewEmployeeFormCommand(String menuLabel, BankEmployee user) {
        super();
        this.menuLabel = menuLabel;
        this.user = user;
    }

    @Override
    public void execute() {
        //working on implementation
        createNewEmployee();
        createNewUser();

    }

    private void createNewUser() {
    }

    @Override
    public String getFieldValue() {
        return null;
    }


    private void createNewEmployee() {
    }


    @Override
    public String getCommandLabel() {
        return menuLabel;
    }

}

