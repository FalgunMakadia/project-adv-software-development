package DataAccessLayer;

import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class WorklistDatabase implements IWorklistDatabase {
    Connection connection = null;
    IDatabaseConnection databaseConnection;

    public WorklistDatabase() {
        databaseConnection = DatabaseConnection.instance();
    }

    @Override
    public int addWorkListRequest(WorklistRequest worklistRequest) {
        connection = databaseConnection.openConnection();
        String insertWorkListQuery = "INSERT INTO worklist " +
                "(request_type, priority, account_number) " +
                "VALUES (? ,?, ?)";
        String insertWorkListUserQuery = "INSERT INTO worklist_user_details " +
                "(worklist_id, account_no, first_name, last_name, " +
                "middle_name, addressline_1, addressline_2, city, " +
                "province, postal_code, email, contact_number, " +
                "passport_number, ssn_number, birth_date) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insertWorkListQuery, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, worklistRequest.getRequestType());
            statement.setString(2, worklistRequest.getPriority());
            statement.setString(3, worklistRequest.getAccountNumber());

            int record_id = statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (null != rs && rs.next()) {
                record_id = rs.getInt(1);
            }

            if (0 != record_id) {
                ProfileAbstract profileAbstract = worklistRequest.getUser();
                PreparedStatement userInsertStatement = connection.prepareStatement(insertWorkListUserQuery);
                userInsertStatement.setInt(1, record_id);
                userInsertStatement.setString(2, worklistRequest.getAccountNumber());
                userInsertStatement.setString(3, profileAbstract.getFirstName());
                userInsertStatement.setString(4, profileAbstract.getLastName());
                userInsertStatement.setString(5, profileAbstract.getMiddleName());
                userInsertStatement.setString(6, profileAbstract.getAddressLine1());
                userInsertStatement.setString(7, profileAbstract.getAddressLine2());
                userInsertStatement.setString(8, profileAbstract.getCity());
                userInsertStatement.setString(9, profileAbstract.getProvince());
                userInsertStatement.setString(10, profileAbstract.getPostalCode());
                userInsertStatement.setString(11, profileAbstract.getEmailAddress());
                userInsertStatement.setString(12, profileAbstract.getContact());
                userInsertStatement.setString(13, profileAbstract.getPassport());
                userInsertStatement.setString(14, profileAbstract.getSsnNo());
                userInsertStatement.setString(15, profileAbstract.getDateOfBirth());

                userInsertStatement.executeUpdate();
            }
            return record_id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return 0;
    }

    @Override
    public WorklistRequest getWorkListRequest(int id) {
        connection = databaseConnection.openConnection();
        String query = "SELECT * from worklist WHERE request_id=?";
        WorklistRequest worklistRequest;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.first()) {
                worklistRequest = new WorklistRequest();
                ProfileAbstract profileAbstract = getUserDetails(id);
                String worklistType = resultSet.getString("request_type");
                String priority = resultSet.getString("priority");
                String accountNumber = resultSet.getString("account_number");
                String handledBy = resultSet.getString("handled_by");

                worklistRequest.setRequestType(worklistType);
                worklistRequest.setPriority(priority);
                worklistRequest.setAccountNumber(accountNumber);
                worklistRequest.setHandledBy(handledBy);
                worklistRequest.setUser(profileAbstract);

                return worklistRequest;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }

        return null;
    }

    @Override
    public Map<Integer, WorklistRequest> getWorkLists() {
        connection = databaseConnection.openConnection();
        Map<Integer, WorklistRequest> worklistRequestMap = new HashMap<>();
        String query = "SELECT * FROM worklist WHERE is_processed = 0";
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
        } finally {
            databaseConnection.closeConnection();
        }
        return worklistRequestMap;
    }

    @Override
    public ProfileAbstract getUserDetails(int id) {
        connection = databaseConnection.openConnection();
        String query = "SELECT * FROM worklist_user_details WHERE worklist_id=?";
        ProfileAbstract profileAbstract = new CustomerProfile();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.first()) {
                profileAbstract.setFirstName(resultSet.getString("first_name"));
                profileAbstract.setLastName(resultSet.getString("last_name"));
                profileAbstract.setMiddleName(resultSet.getString("middle_name"));
                profileAbstract.setAddressLine1(resultSet.getString("addressline_1"));
                profileAbstract.setAddressLine2(resultSet.getString("addressline_2"));
                profileAbstract.setCity(resultSet.getString("city"));
                profileAbstract.setProvince(resultSet.getString("province"));
                profileAbstract.setPostalCode(resultSet.getString("postal_code"));
                profileAbstract.setEmailAddress(resultSet.getString("email"));
                profileAbstract.setContact(resultSet.getString("contact_number"));
                profileAbstract.setPassport(resultSet.getString("passport_number"));
                profileAbstract.setSsnNo(resultSet.getString("ssn_number"));
                profileAbstract.setAccountNumber(resultSet.getString("account_no"));
                profileAbstract.setDateOfBirth(resultSet.getString("birth_date"));

                return profileAbstract;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return null;
    }

    @Override
    public boolean updateAssignee(int id, String assigneeUsername) {
        connection = databaseConnection.openConnection();
        String query = "UPDATE worklist SET handled_by = ? WHERE request_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, assigneeUsername);
            statement.setInt(2, id);

            int affectedRows = statement.executeUpdate();
            return affectedRows == 1 ? true : false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return false;
    }

    @Override
    public boolean updateProcessStatus(int worklistId, Boolean isProcessed) {
        connection = databaseConnection.openConnection();
        String query = "UPDATE worklist SET is_processed = ? WHERE request_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setBoolean(1, isProcessed);
            statement.setInt(2, worklistId);

            return statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return false;
    }
}
