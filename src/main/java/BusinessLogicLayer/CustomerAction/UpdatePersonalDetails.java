package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.ICustomerDatabase;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;
import Models.User;

import java.sql.SQLException;

public class UpdatePersonalDetails extends Action {
    private static final String menuLabel = "Update Personal Details";
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }
    @Override
    public void performAction() {
        System.out.println("Update Personal Details");
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        ICustomerDatabase customerDatabase = databaseFactory.createCustomerDatabase();
        try {
            User user = customerDatabase.getUser("9727856302");
            System.out.println("Welcome: " + user.getFirstName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
