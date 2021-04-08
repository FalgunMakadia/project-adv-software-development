package DataAccessLayer.OperationDatabase;

import BusinessLogicLayer.TransactionAction.ITransactionActionFactory;
import BusinessLogicLayer.TransactionAction.ITransactionModel;
import BusinessLogicLayer.TransactionAction.TransactionActionFactory;
import DataAccessLayer.DatabaseConnection.DatabaseConnectionFactory;
import DataAccessLayer.DatabaseConnection.IDatabaseConnection;
import DataAccessLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountOperationDatabase implements IAccountOperationDatabase {
    private static final String BALANCE_COLUMN_NAME = "balance";
    private static final String ACTIVE_STATUS_COLUMN_NAME = "active_status";
    private static final String TRANSACTION_TYPE_COLUMN_NAME = "transaction_type";
    private static final String TRANSACTION_AMOUNT_COLUMN_NAME = "transaction_amount";
    private static final String TRANSACTION_DATE_COLUMN_NAME = "transaction_date";


    Connection connection = null;
    IDatabaseConnection databaseConnection;
    ITransactionActionFactory transactionActionFactory;
    IDatabaseConnectionFactory databaseConnectionFactory;

    public AccountOperationDatabase() {
        databaseConnectionFactory = new DatabaseConnectionFactory();
        databaseConnection = databaseConnectionFactory.getDatabaseConnection();
        transactionActionFactory = new TransactionActionFactory();
    }

    @Override
    public int getBalance(String accountNumber) {
        connection = databaseConnection.openConnection();
        String query = "SELECT balance FROM accounts WHERE account_no = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);

            statement.setString(1, accountNumber);
            ResultSet rs = statement.executeQuery();
            int balance = 0;
            if (rs.next()) {
                balance = rs.getInt(BALANCE_COLUMN_NAME);
            }
            return balance;
        } catch (SQLException exception) {
            exception.getMessage();
        } catch (Exception exception) {
            exception.getMessage();
        } finally {
            databaseConnection.closeConnection();
        }
        return 0;
    }

    @Override
    public int updateBalance(int finalBalance, String accountNumber) {
        connection = databaseConnection.openConnection();
        String query = "UPDATE accounts SET balance = ? WHERE account_no = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);

            statement.setInt(1, finalBalance);
            statement.setString(2, accountNumber);
            int output = statement.executeUpdate();
            return output;
        } catch (SQLException exception) {
            exception.getMessage();
        } catch (Exception exception) {
            exception.getMessage();
        } finally {
            databaseConnection.closeConnection();
        }
        return 0;
    }

    @Override
    public boolean verifyAccountNumber(String accountNumber) {
        connection = databaseConnection.openConnection();
        String query = "SELECT * FROM accounts WHERE account_no = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);

            statement.setString(1, accountNumber);
            ResultSet rs = statement.executeQuery();
            boolean accountStatus = false;
            if (rs.next()) {
                accountStatus = rs.getBoolean(ACTIVE_STATUS_COLUMN_NAME);
            }
            return accountStatus;
        } catch (SQLException exception) {
            exception.getMessage();
        } catch (Exception exception) {
            exception.getMessage();
        } finally {
            databaseConnection.closeConnection();
        }
        return false;
    }

    @Override
    public void saveTransaction(ArrayList<ITransactionModel> saveTransactionInModel) {
        connection = databaseConnection.openConnection();

        String query = "INSERT INTO transactions VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            for (ITransactionModel transaction : saveTransactionInModel) {
                statement.setString(1, transaction.generateRandomTransactionId());
                statement.setString(2, transaction.getAccountNumber());
                statement.setString(3, transaction.getTransactionType());
                statement.setInt(4, transaction.getAmount());
                statement.setString(5, transaction.getCurrentDate());

                statement.executeUpdate();
            }
        } catch (SQLException exception) {
            exception.getMessage();
        } catch (Exception exception) {
            exception.getMessage();
        } finally {
            databaseConnection.closeConnection();
        }
    }

    @Override
    public ArrayList<ITransactionModel> getMiniStatement(String accountNumber) {
        connection = databaseConnection.openConnection();
        String query = "SELECT * FROM transactions WHERE account_no = ? ORDER BY transaction_date DESC LIMIT 5";
        ArrayList<ITransactionModel> transactionList = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, accountNumber);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String transactionType = resultSet.getString(TRANSACTION_TYPE_COLUMN_NAME);
                int amount = resultSet.getInt(TRANSACTION_AMOUNT_COLUMN_NAME);
                String date = resultSet.getString(TRANSACTION_DATE_COLUMN_NAME);
                transactionList.add(transactionActionFactory.createTransactionModel(accountNumber, transactionType, amount, date));
            }
        } catch (SQLException exception) {
            exception.getMessage();
        } catch (Exception exception) {
            exception.getMessage();
        } finally {
            databaseConnection.closeConnection();
        }
        return transactionList;
    }

}
