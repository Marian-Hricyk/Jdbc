package org.example;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
  H2Config h2Config = new H2Config();

  long create(String name) {
    Connection connection = h2Config.getConections();
    String query = "INSERT INTO client (ID, 'NAME') VALUES (DEFAULT, '?');";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, name);
      int rowsAffected = preparedStatement.executeUpdate();

      if (rowsAffected > 0) {

        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
          if (generatedKeys.next()) {

            long generatedId = generatedKeys.getLong(1);
            return generatedId;
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return 0;
  }

  List<Client> listAll() {
    List<Client> clients = new ArrayList<>();
    Connection connection = h2Config.getConections();
    String query = "SELECT * FROM client;";

    try (PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {

      while (resultSet.next()) {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("NAME");

        Client client = new Client(id, name);
        clients.add(client);
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return clients;
  }
}
