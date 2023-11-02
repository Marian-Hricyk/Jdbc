package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Database {
  private static final Database insort = new Database();
  private Connection connection;
  private Database() {
      // URL, користувач та пароль для підключення до бази даних
      String url = "jdbc:postgresql://localhost:5432/mydb"; // замініть на ваш URL
      String user = "yourUsername"; // замініть на свого користувача
      String password = "yourPassword"; // замініть на свій пароль

      try {
        // Встановлюємо з'єднання з базою даних
        connection = DriverManager.getConnection(url, user, password);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }


    public static Database getInstance () {
      return insort;
    }

    public Connection getConnection () {
      return connection;
    }
}
