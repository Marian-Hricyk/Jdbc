/*package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
  private static final Database insort = new Database();
  private Connection connection;

  private Database() {
    // URL, користувач та пароль для підключення до бази даних
    String url = "jdbc:postgresql://localhost:5432/java143"; // замініть на ваш URL
    String user = "postgres"; // замініть на свого користувача
    String password = "123456654321"; // замініть на свій пароль

    try {
      // Встановлюємо з'єднання з базою даних
      connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  public static Database getInstance() {
    return insort;
  }

  public Connection getConnection() {
    return connection;
  }
}*/
