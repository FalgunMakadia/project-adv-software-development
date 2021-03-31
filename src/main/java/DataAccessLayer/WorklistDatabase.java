package DataAccessLayer;

import BusinessLogicLayer.User.Customer;
import BusinessLogicLayer.User.User;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class WorklistDatabase implements IWorklistDatabase {
    Connection connection = null;

    public WorklistDatabase() {
        connection = DatabaseConnection.instance();
    }

    @Override
    public int addWorkListRequest(WorklistRequest worklistRequest) throws SQLException {
        String insertWorkListQuery = "INSERT INTO worklist " +
                "(request_type, priority, account_number, handled_by) " +
                "VALUES (? ,?, ?, ?)";
        String insertWorkListUserQuery = "INSERT INTO worklist_user_details " +
                "(worklist_id, account_no, first_name, last_name, " +
                "middle_name, addressline_1, addressline_2, city, " +
                "province, postal_code, email, contact_number, " +
                "passport_number, ssn_number) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(insertWorkListQuery, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, worklistRequest.getRequestType());
        statement.setString(2, worklistRequest.getPriority());
        statement.setString(3, worklistRequest.getAccountNumber());
        statement.setString(4, null);

        int record_id = statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        if (null != rs && rs.next()) {
            record_id = rs.getInt(1);
        }

        if (0 != record_id) {
            User user = worklistRequest.getUser();
            PreparedStatement userInsertStatement = connection.prepareStatement(insertWorkListUserQuery);
            userInsertStatement.setInt(1, record_id);
            userInsertStatement.setString(2, worklistRequest.getAccountNumber());
            userInsertStatement.setString(3, user.getFirstName());
            userInsertStatement.setString(4, user.getLastName());
            userInsertStatement.setString(5, user.getMiddleName());
            userInsertStatement.setString(6, user.getAddressLine1());
            userInsertStatement.setString(7, user.getAddressLine2());
            userInsertStatement.setString(8, user.getCity());
            userInsertStatement.setString(9, user.getProvince());
            userInsertStatement.setString(10, user.getPostalCode());
            userInsertStatement.setString(11, user.getEmailAddress());
            userInsertStatement.setString(12, user.getContact());
            userInsertStatement.setString(13, user.getPassport());
            userInsertStatement.setString(14, user.getSsnNo());

            userInsertStatement.executeUpdate();
        }

        return record_id;
    }

    @Override
    public WorklistRequest getWorkListRequest(int id) {
        String query = "SELECT * from worklist WHERE request_id=?";
        WorklistRequest worklistRequest;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.first()) {
                worklistRequest = new WorklistRequest();
                User user = getUserDetails(id);
                String worklistType = resultSet.getString("request_type");
                String priority = resultSet.getString("priority");
                String accountNumber = resultSet.getString("account_number");
                String handledBy = resultSet.getString("handled_by");

                worklistRequest.setRequestType(worklistType);
                worklistRequest.setPriority(priority);
                worklistRequest.setAccountNumber(accountNumber);
                worklistRequest.setHandledBy(handledBy);
                worklistRequest.setUser(user);

                return worklistRequest;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public Map<Integer, WorklistRequest> getWorkLists() {
        Map<Integer, WorklistRequest> worklistRequestMap = new HashMap<>();
        String query = "SELECT * FROM worklist";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int requestId = resultSet.getInt("request_id");
                WorklistRequest worklistRequest = new WorklistRequest();
                worklistRequest.setRequestType(resultSet.getString("request_type"));
                worklistRequest.setPriority(resultSet.getString("priority"));
                worklistRequest.setAccountNumber(resultSet.getString("account_number"));
                worklistRequest.setHandledBy(resultSet.getString("handled_by"));
                worklistRequestMap.put(requestId, worklistRequest);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return worklistRequestMap;
    }

    @Override
    public User getUserDetails(int id) {
        String query = "SELECT * FROM worklist_user_details WHERE worklist_id=?";
        User user = new Customer();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.first()) {
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setMiddleName(resultSet.getString("middle_name"));
                user.setAddressLine1(resultSet.getString("addressline_1"));
                user.setAddressLine2(resultSet.getString("addressline_2"));
                user.setCity(resultSet.getString("city"));
                user.setProvince(resultSet.getString("province"));
                user.setPostalCode(resultSet.getString("postal_code"));
                user.setEmailAddress(resultSet.getString("email"));
                user.setContact(resultSet.getString("contact_number"));
                user.setPassport(resultSet.getString("passport_number"));
                user.setSsnNo(resultSet.getString("ssn_number"));
                user.setAccountNumber(resultSet.getString("account_no"));
                user.setDateOfBirth(resultSet.getString("birth_date"));

                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateAssignee(int id, String assigneeUsername) {
        String query = "UPDATE worklist SET handled_by = ? WHERE request_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, assigneeUsername);
            statement.setInt(2, id);

            int affectedRows = statement.executeUpdate();
            return affectedRows == 1 ? true : false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
