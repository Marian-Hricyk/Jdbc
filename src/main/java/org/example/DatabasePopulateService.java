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
      StringBuilder qury = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        qury.append(line);
      }


      Statement statement = connection.createStatement();
      statement.executeUpdate(qury.toString());
      statement.close();
      reader.close();
      System.out.println("Таблиці бази даних успішно заповнено даними.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
