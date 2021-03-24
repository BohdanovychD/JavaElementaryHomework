package lesson_21.service;

import lesson_21.database.Database;
import lesson_21.entity.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private static final String SELECT_ALL_ACCOUNTS_QUERY = "SELECT * FROM accounts";
    private static final String SAVE_ACCOUNTS_QUERY = "INSERT INTO accounts (client_id, number, value)" +
            "VALUES (?, ?, ?)";
    private static final String UPDATE_ACCOUNTS_QUERY = "UPDATE accounts SET client_id = ?, number = ?, value = ? WHERE id = ?";
    private static final String DELETE_ACCOUNTS_QUERY = "DELETE FROM accounts WHERE id = ?";
    private static final String SELECT_NUMBER_QUERY = "SELECT number FROM accounts where value >= ?";

    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ACCOUNTS_QUERY);
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setClientId(resultSet.getLong("client_id"));
                account.setNumber(resultSet.getString("number"));
                account.setValue(resultSet.getDouble("value"));
                accounts.add(account);
            }
//            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public void save(Account account) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_ACCOUNTS_QUERY)) {
            preparedStatement.setLong(1, account.getClientId());
            preparedStatement.setString(2, account.getNumber());
            preparedStatement.setDouble(3, account.getValue());
            preparedStatement.execute();
//                 connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Account account, long id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNTS_QUERY)) {
            preparedStatement.setLong(1, account.getClientId());
            preparedStatement.setString(2, account.getNumber());
            preparedStatement.setDouble(3, account.getValue());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
//            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNTS_QUERY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
//            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void numberByValue(double value) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NUMBER_QUERY)) {
                preparedStatement.setDouble(1, value);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("number"));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
