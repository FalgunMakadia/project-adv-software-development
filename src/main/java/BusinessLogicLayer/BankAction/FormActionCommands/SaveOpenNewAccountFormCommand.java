package BusinessLogicLayer.BankAction.FormActionCommands;

import BusinessLogicLayer.User.User;
import DataAccessLayer.IDatabaseFactory;

public class SaveOpenNewAccountFormCommand extends FormActionCommand {
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
        //working on implementation
        createNewCustomer();
        createNewAccount();
        createNewUser();
    }

    private void createNewUser() {
    }

    private void createNewCustomer() {
    }

    private void createNewAccount() {
    }

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

}
