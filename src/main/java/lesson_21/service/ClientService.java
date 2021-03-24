package lesson_21.service;

import lesson_21.database.Database;
import lesson_21.entity.Account;
import lesson_21.entity.Client;
import lesson_21.entity.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static final String SELECT_ALL_CLIENTS_QUERY = "SELECT * FROM clients";
    private static final String SAVE_CLIENT_QUERY = "INSERT INTO clients (name, email, about, phone, age)" +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_CLIENT_QUERY = "UPDATE clients SET name = ?, email = ?, about = ?," +
            " phone = ?, age = ? WHERE id = ?";
    private static final String DELETE_CLIENT_QUERY = "DELETE FROM clients WHERE id = ?";
    private static final String PHONE_SEARCH_QUERY = "SELECT * FROM clients WHERE phone = ?";
    private static final String GET_ALL_CLIENTS_FROM_ACCOUNTS_QUERY = "SELECT * FROM clients " +
            "INNER JOIN accounts ON clients.id = accounts.client_id";
    private static final String GET_SOME_INFO_FROM_TWO_TABLE_QUERY = "SELECT clients.name, clients.email, statuses.alias FROM clients " +
            "INNER JOIN client_status  ON clients.id = client_status.client_id " +
            "INNER JOIN statuses  ON statuses.id = client_status.status_id WHERE age >= 18";


    List<Client> clients = new ArrayList<>();
    Client client = new Client();

    public List<Client> getAll() {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CLIENTS_QUERY);
            while (resultSet.next()) {
                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setAbout(resultSet.getString("about"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAge(resultSet.getInt("age"));
                clients.add(client);
            }
//            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void save(Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CLIENT_QUERY)) {
                 preparedStatement.setString(1, client.getName());
                 preparedStatement.setString(2, client.getEmail());
                 preparedStatement.setString(3, client.getAbout());
                 preparedStatement.setLong(4, client.getPhone());
                 preparedStatement.setInt(5, client.getAge());
                 preparedStatement.execute();
//                 connection.commit();
        } catch (SQLException e) {
                 e.printStackTrace();
        }
    }

    public void update(Client client, long id) {
        try (Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT_QUERY)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setString(3, client.getAbout());
            preparedStatement.setLong(4, client.getPhone());
            preparedStatement.setInt(5, client.getAge());
            preparedStatement.setLong(6, id);
            preparedStatement.executeUpdate();
//            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_QUERY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
//            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void phoneSearch(long phone) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(PHONE_SEARCH_QUERY)) {
            preparedStatement.setLong(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getLong("id") + "\t" +
                        resultSet.getString("name") + "\t" +
                        resultSet.getString("email") + "\t" +
                        resultSet.getString("about") + "\t" +
                        resultSet.getLong("phone") + "\t" +
                        resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clientsFromAccount() {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_CLIENTS_FROM_ACCOUNTS_QUERY);
            while (resultSet.next()) {
                System.out.println(resultSet.getLong("id") + "\t" +
                        resultSet.getString("name") + "\t" +
                        resultSet.getString("email") + "\t" +
                        resultSet.getString("about") + "\t" +
                        resultSet.getLong("phone") + "\t" +
                        resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clientsFromTwoTables() {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_SOME_INFO_FROM_TWO_TABLE_QUERY);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + "\t" +
                        resultSet.getString("email") + "\t" +
                        resultSet.getString("alias"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
