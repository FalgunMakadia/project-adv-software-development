package BusinessLogicLayer.BankAction;

import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;

public class OpenNewAccountFormSaveState extends FormState {
    private String menuLabel;
    private IDatabaseFactory databaseFactory;

    public OpenNewAccountFormSaveState() {
        super();
        databaseFactory = new DatabaseFactory();

    }

    public OpenNewAccountFormSaveState(String menuLabel) {
        super();
        this.menuLabel = menuLabel;
    }

    @Override
    public void performStateTask() {
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
