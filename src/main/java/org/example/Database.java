/*package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
  private static final Database insort = new Database();
  private Connection connection;

  private Database() {
    // URL, ���������� �� ������ ��� ���������� �� ���� �����
    String url = "jdbc:postgresql://localhost:5432/java143"; // ������ �� ��� URL
    String user = "postgres"; // ������ �� ����� �����������
    String password = "123456654321"; // ������ �� ��� ������

    try {
      // ������������ �'������� � ����� �����
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
