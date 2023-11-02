package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

public class DatabasePopulateService {
  public static void main(String[] args) {
    Database database = Database.getInstance();
    Connection connection = database.getConnection();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("sql/populate_db.sql"));
      String qeury;
      Statement statement = connection.createStatement();
      while ((qeury = reader.readLine()) != null) {
        statement.executeUpdate(qeury);
      }
      reader.close();
      statement.close();
      System.out.println("Таблиці бази даних успішно заповнено даними.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
