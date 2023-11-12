/*package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
  public static void main(String[] args) {
    try (Connection connection = database.getConnection()) {
      String query = "INSERT INTO worker (ID, NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?, ?, ?, ?, ?)";

      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        // Додайте дані до запиту
        addWorker(preparedStatement, 1, "John Doe", "1990-01-15", "Senior", 6000);
        addWorker(preparedStatement, 2, "Jane Smith", "1992-03-22", "Middle", 4000);
        addWorker(preparedStatement, 3, "Tom Johnson", "1995-08-10", "Junior", 2500);
        addWorker(preparedStatement, 4, "Alice Brown", "1998-12-04", "Trainee", 1200);
        addWorker(preparedStatement, 5, "Mike Wilson", "1985-07-31", "Senior", 8000);
        addWorker(preparedStatement, 6, "Emily Davis", "1993-09-18", "Middle", 4500);
        addWorker(preparedStatement, 7, "Chris Lee", "1997-11-29", "Junior", 2800);
        addWorker(preparedStatement, 8, "Sarah Taylor", "1994-05-06", "Middle", 4300);
        addWorker(preparedStatement, 9, "David Clark", "1987-06-13", "Junior", 2600);
        addWorker(preparedStatement, 10, "Linda Martinez", "1999-04-22", "Trainee", 1100);

        preparedStatement.executeBatch();
      }

      String queryClin= "insert into client (ID,NAME) VALUES(?,?)";
      try (PreparedStatement preparedStatementCliant = connection.prepareStatement(queryClin)) {
        addClient(preparedStatementCliant, 1, "Stark");
        addClient(preparedStatementCliant, 2, "Lannister");
        addClient(preparedStatementCliant, 3, "Targaryen");
        addClient(preparedStatementCliant, 4, "Baratheo");
        addClient(preparedStatementCliant, 5, "Greyjoy");
        preparedStatementCliant.executeBatch();
      }
        String projectQuery = "INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?, ?, ?, ?)";
        try (PreparedStatement projectStatement = connection.prepareStatement(projectQuery)) {
          // Додавання декількох проектів
          addProject(projectStatement, 1, 1, "2023-01-01", "2023-03-31");
          addProject(projectStatement, 2, 2, "2023-02-15", "2023-05-30");
          addProject(projectStatement, 3, 3, "2023-03-10", "2023-08-15");
          addProject(projectStatement, 4, 4, "2023-04-05", "2023-07-10");
          addProject(projectStatement, 5, 5, "2023-05-20", "2023-09-30");
          addProject(projectStatement, 6, 1, "2023-06-15", "2023-09-15");
          addProject(projectStatement, 7, 2, "2023-07-01", "2023-10-20");
          addProject(projectStatement, 8, 3, "2023-08-10", "2023-12-25");
          addProject(projectStatement, 9, 4, "2023-09-05", "2023-11-20");
          addProject(projectStatement, 10, 5, "2023-10-15", "2023-12-31");

          projectStatement.executeBatch();
        }

        // Вставка даних в таблицю project_worker
        String projectWorkerQuery = "INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (?, ?)";
        try (PreparedStatement projectWorkerStatement = connection.prepareStatement(projectWorkerQuery)) {
          // Додавання декількох робітників проекту
          addProjectWorker(projectWorkerStatement, 1, 1);
          addProjectWorker(projectWorkerStatement, 1, 2);
          addProjectWorker(projectWorkerStatement, 2, 3);
          addProjectWorker(projectWorkerStatement, 2, 4);
          addProjectWorker(projectWorkerStatement, 3, 5);
          addProjectWorker(projectWorkerStatement, 3, 6);
          addProjectWorker(projectWorkerStatement, 4, 7);
          addProjectWorker(projectWorkerStatement, 5, 8);
          addProjectWorker(projectWorkerStatement, 6, 9);
          addProjectWorker(projectWorkerStatement, 7, 10);

          projectWorkerStatement.executeBatch();
        }

        System.out.println("Дані успішно додано до бази даних.");
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    private static void addProject(PreparedStatement preparedStatement, int id, int clientId, String startDate, String finishDate) throws SQLException {
      preparedStatement.setInt(1, id);
      preparedStatement.setInt(2, clientId);
      preparedStatement.setString(3, startDate);
      preparedStatement.setString(4, finishDate);
      preparedStatement.addBatch();
    }

    private static void addProjectWorker(PreparedStatement preparedStatement, int projectId, int workerId) throws SQLException {
      preparedStatement.setInt(1, projectId);
      preparedStatement.setInt(2, workerId);
      preparedStatement.addBatch();
    }

  private static void addWorker(PreparedStatement preparedStatement, int id, String name, String birthday, String level, int salary) throws SQLException {
    preparedStatement.setInt(1, id);
    preparedStatement.setString(2, name);
    preparedStatement.setString(3, birthday);
    preparedStatement.setString(4, level);
    preparedStatement.setInt(5, salary);
    preparedStatement.addBatch();
  }

  private static void addClient(PreparedStatement preparedStatement, int id, String name) throws SQLException {
    preparedStatement.setInt(1, id);
    preparedStatement.setString(2, name);
    preparedStatement.addBatch();
  }
}*/
