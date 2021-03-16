package BusinessLogicLayer.CustomerAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.ICustomerDatabase;
import DataAccessLayer.DatabaseFactory;
import Models.User;

import java.sql.SQLException;

public class UpdatePersonalDetails extends Action {
    @Override
    public void performAction() {
        System.out.println("Update Personal Details");
        DatabaseFactory factory = new DatabaseFactory();
        ICustomerDatabase db = factory.createCustomerDatabase();
        try {
            User user = db.getUser("9727856302");
            System.out.println("Welcome: " + user.getFirstName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
