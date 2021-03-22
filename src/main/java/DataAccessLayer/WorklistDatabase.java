package DataAccessLayer;

import BusinessLogicLayer.User.User;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class WorklistDatabase implements IWorklistDatabase {
    Connection connection = null;

    public WorklistDatabase() {
        connection = DatabaseConnection.instance();
    }

    @Override
    public int addWorkListRequest(WorklistRequest worklistRequest) throws SQLException {
        String insertWorkListQuery = "INSERT INTO worklist (request_type, priority, account_ number) values (? ,? ,? )";
        String insertWorkListUserQuery = "INSERT INTO worklist_user_details " +
                "(worklist_id, account_no, first_name, last_name, " +
                "middle_name, addressline_1, addressline_2, city, " +
                "province, postal_code, email, contact_number, " +
                "passport_number, ssn_number) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(insertWorkListQuery);

//        statement.setString(1, worklistRequest.getRequestType());
//        statement.setString(2, worklistRequest.getPriority());
//        statement.setString(3, worklistRequest.getAccountNumber());
//
//        int record_id = statement.executeUpdate();
//
//        if(0 != record_id) {
//            User user = worklistRequest.getUser();
//            PreparedStatement userInsertStatement = connection.prepareStatement(insertWorkListUserQuery);
//            userInsertStatement.setInt(1, record_id);
//            userInsertStatement.setString(2,worklistRequest.getAccountNumber());
//            userInsertStatement.setString(3, user.getFirstName());
//            userInsertStatement.setString(4,user.getLastName());
//            userInsertStatement.setString(5,user.getMiddleName());
//            userInsertStatement.setString(6,user.getAddressLine1());
//            userInsertStatement.setString(7,user.getAddressLine2());
//            userInsertStatement.setString(8,user.getCity());
//            userInsertStatement.setString(9,user.getProvince());
//            userInsertStatement.setString(10,user.getPostalCode());
//            userInsertStatement.setString(11,user.getEmailAddress());
//            userInsertStatement.setString(12,user.getContact());
//            userInsertStatement.setString(13,user.getPassport());
//            userInsertStatement.setString(14,user.getSsnNo());
//
//            userInsertStatement.executeUpdate();
//        }

        return 0;
    }

    @Override
    public WorklistRequest getWorkListRequest(int id) {
        return null;
    }
}
