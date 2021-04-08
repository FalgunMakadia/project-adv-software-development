package DataAccessLayer.OperationDatabase;

import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.WorkListRequestActions.IWorkListRequestActionFactory;
import BusinessLogicLayer.WorkListRequestActions.IWorkListRequest;
import BusinessLogicLayer.WorkListRequestActions.WorkListRequestActionFactory;
import DataAccessLayer.DatabaseConnection.DatabaseConnection;
import DataAccessLayer.DatabaseConnection.IDatabaseConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class WorklistOperationDatabase implements IWorklistOperationDatabase {
    private static final String REQUEST_ID_COLUMN_NAME = "request_id";
    private static final String REQUEST_TYPE_COLUMN_NAME = "request_type";
    private static final String PRIORITY_COLUMN_NAME = "priority";
    private static final String WORKLIST_ACCOUNT_NUMBER_COLUMN_NAME = "account_number";
    private static final String HANDLED_BY_COLUMN_NAME = "handled_by";
    private static final String FIRST_NAME_COLUMN_NAME = "first_name";
    private static final String LAST_NAME_COLUMN_NAME = "last_name";
    private static final String MIDDLE_NAME_COLUMN_NAME = "middle_name";
    private static final String ADDRESSLINE_1_COLUMN_NAME = "addressline_1";
    private static final String ADDRESSLINE_2_COLUMN_NAME = "addressline_2";
    private static final String CITY_COLUMN_NAME = "city";
    private static final String PROVINCE_COLUMN_NAME = "province";
    private static final String POSTAL_CODE_COLUMN_NAME = "postal_code";
    private static final String EMAIL_COLUMN_NAME = "email";
    private static final String CONTACT_NUMBER_COLUMN_NAME = "contact_number";
    private static final String PASSPORT_NUMBER_COLUMN_NAME = "passport_number";
    private static final String SSN_NUMBER_COLUMN_NAME = "ssn_number";
    private static final String ACCOUNT_NUMBER_COLUMN_NAME = "account_no";
    private static final String BIRTH_DATE_COLUMN_NAME = "birth_date";

    Connection connection = null;
    IDatabaseConnection databaseConnection;

    public WorklistOperationDatabase() {
        databaseConnection = DatabaseConnection.instance();
    }

    @Override
    public int addWorkListRequest(IWorkListRequest workListRequest) {
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

            statement.setString(1, workListRequest.getRequestType());
            statement.setString(2, workListRequest.getPriority());
            statement.setString(3, workListRequest.getAccountNumber());

            int record_id = statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (null != rs && rs.next()) {
                record_id = rs.getInt(1);
            }

            if (0 != record_id) {
                AbstractProfile profile = workListRequest.getUser();
                PreparedStatement userInsertStatement = connection.prepareStatement(insertWorkListUserQuery);
                userInsertStatement.setInt(1, record_id);
                userInsertStatement.setString(2, workListRequest.getAccountNumber());
                userInsertStatement.setString(3, profile.getFirstName());
                userInsertStatement.setString(4, profile.getLastName());
                userInsertStatement.setString(5, profile.getMiddleName());
                userInsertStatement.setString(6, profile.getAddressLine1());
                userInsertStatement.setString(7, profile.getAddressLine2());
                userInsertStatement.setString(8, profile.getCity());
                userInsertStatement.setString(9, profile.getProvince());
                userInsertStatement.setString(10, profile.getPostalCode());
                userInsertStatement.setString(11, profile.getEmailAddress());
                userInsertStatement.setString(12, profile.getContact());
                userInsertStatement.setString(13, profile.getPassport());
                userInsertStatement.setString(14, profile.getSsnNo());
                userInsertStatement.setString(15, profile.getDateOfBirth());

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
    public IWorkListRequest getWorkListRequest(int id) {
        connection = databaseConnection.openConnection();
        String query = "SELECT * from worklist WHERE request_id=?";
        IWorkListRequest workListRequest;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.first()) {
                IWorkListRequestActionFactory workListActionFactory = new WorkListRequestActionFactory();
                workListRequest = workListActionFactory.createWorkListRequest();
                AbstractProfile profile = getWorkListUserDetail(id);
                String worklistType = resultSet.getString(REQUEST_TYPE_COLUMN_NAME);
                String priority = resultSet.getString(PRIORITY_COLUMN_NAME);
                String accountNumber = resultSet.getString(WORKLIST_ACCOUNT_NUMBER_COLUMN_NAME);
                String handledBy = resultSet.getString(HANDLED_BY_COLUMN_NAME);

                workListRequest.setRequestType(worklistType);
                workListRequest.setPriority(priority);
                workListRequest.setAccountNumber(accountNumber);
                workListRequest.setHandledBy(handledBy);
                workListRequest.setUser(profile);

                return workListRequest;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }

        return null;
    }

    @Override
    public Map<Integer, IWorkListRequest> getWorkList() {
        connection = databaseConnection.openConnection();
        Map<Integer, IWorkListRequest> workListRequestMap = new HashMap<>();
        String query = "SELECT * FROM worklist WHERE is_processed = 0";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int requestId = resultSet.getInt(REQUEST_ID_COLUMN_NAME);
                IWorkListRequestActionFactory workListActionFactory = new WorkListRequestActionFactory();
                IWorkListRequest workListRequest = workListActionFactory.createWorkListRequest();
                workListRequest.setRequestType(resultSet.getString(REQUEST_TYPE_COLUMN_NAME));
                workListRequest.setPriority(resultSet.getString(PRIORITY_COLUMN_NAME));
                workListRequest.setAccountNumber(resultSet.getString(WORKLIST_ACCOUNT_NUMBER_COLUMN_NAME));
                workListRequest.setHandledBy(resultSet.getString(HANDLED_BY_COLUMN_NAME));
                workListRequestMap.put(requestId, workListRequest);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return workListRequestMap;
    }

    @Override
    public AbstractProfile getWorkListUserDetail(int id) {
        connection = databaseConnection.openConnection();
        String query = "SELECT * FROM worklist_user_details WHERE worklist_id=?";
        AbstractProfile profile = new CustomerProfile();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.first()) {
                profile.setFirstName(resultSet.getString(FIRST_NAME_COLUMN_NAME));
                profile.setLastName(resultSet.getString(LAST_NAME_COLUMN_NAME));
                profile.setMiddleName(resultSet.getString(MIDDLE_NAME_COLUMN_NAME));
                profile.setAddressLine1(resultSet.getString(ADDRESSLINE_1_COLUMN_NAME));
                profile.setAddressLine2(resultSet.getString(ADDRESSLINE_2_COLUMN_NAME));
                profile.setCity(resultSet.getString(CITY_COLUMN_NAME));
                profile.setProvince(resultSet.getString(PROVINCE_COLUMN_NAME));
                profile.setPostalCode(resultSet.getString(POSTAL_CODE_COLUMN_NAME));
                profile.setEmailAddress(resultSet.getString(EMAIL_COLUMN_NAME));
                profile.setContact(resultSet.getString(CONTACT_NUMBER_COLUMN_NAME));
                profile.setPassport(resultSet.getString(PASSPORT_NUMBER_COLUMN_NAME));
                profile.setSsnNo(resultSet.getString(SSN_NUMBER_COLUMN_NAME));
                profile.setAccountNumber(resultSet.getString(ACCOUNT_NUMBER_COLUMN_NAME));
                profile.setDateOfBirth(resultSet.getString(BIRTH_DATE_COLUMN_NAME));
                return profile;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return null;
    }

    @Override
    public boolean assignWorkListRequest(int id, String assigneeUsername) {
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
    public boolean updateWorkListStatus(int worklistId, Boolean isProcessed) {
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
