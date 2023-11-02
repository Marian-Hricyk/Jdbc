package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
  private Connection connection;

  DatabaseQueryService() {
    this.connection = Database.getInstance().getConnection();
  }

  public List<MaxProjectCountClient> findMaxProjectsClient() {
    List<MaxProjectCountClient> result = new ArrayList<>();
    try {

      Connection connection = Database.getInstance().getConnection();


      BufferedReader reader = new BufferedReader(new FileReader("sql/find_max_projects_client.sql"));
      StringBuilder query = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        query.append(line).append(" ");
      }


      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query.toString());

      while (resultSet.next()) {

        String name = resultSet.getString("NAME");
        int projectCount = resultSet.getInt("PROJECT_COUNT");
        MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);


        result.add(client);
      }


      resultSet.close();
      statement.close();
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }

    return result;
  }

  public List<ProjectPrices> printProjectprices() {
    List<ProjectPrices> result = new ArrayList<>();
    try {
      Connection connection = Database.getInstance().getConnection();

      BufferedReader reader = new BufferedReader(new FileReader("sql/print_project_prtices.sql"));
      StringBuilder query = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        query.append(line).append(" ");
      }


      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query.toString());

      while (resultSet.next()) {

        int id = resultSet.getInt("PROJECT_ID");
        String start = resultSet.getString("START_DATE");
        String finish = resultSet.getString("FINISH_DATE");
        int cost = resultSet.getInt("PROJECT_COST");
        ProjectPrices client = new ProjectPrices(id, start, finish,cost);


        result.add(client);
      }
      resultSet.close();
      statement.close();
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }
    return result;
  }
  public List<MaxSalaryWorker> findMaxSalaryWorkers() {
    List<MaxSalaryWorker> result = new ArrayList<>();
    try {
      Connection connection = Database.getInstance().getConnection();


      BufferedReader reader = new BufferedReader(new FileReader("sql/find_max_salary_worker.sql"));
      StringBuilder query = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        query.append(line).append(" ");
      }

      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query.toString());

      while (resultSet.next()) {

        int salary = resultSet.getInt("SALARY");
        String name = resultSet.getString("NAME");
        MaxSalaryWorker client = new MaxSalaryWorker(salary, name);

        result.add(client);
      }
      resultSet.close();
      statement.close();
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }

    return result;
  }

  public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
    List<YoungestEldestWorkers> result = new ArrayList<>();
    try {
      Connection connection = Database.getInstance().getConnection();

      BufferedReader reader = new BufferedReader(new FileReader("sql/find_youngest_eldest_workers.sql"));
      StringBuilder query = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        query.append(line).append(" ");
      }

      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query.toString());

      while (resultSet.next()) {

        int birthday = resultSet.getInt("BIRTHDAY");
        String name = resultSet.getString("NAME");
        String type= resultSet.getString("Typ");
        YoungestEldestWorkers client = new YoungestEldestWorkers(name, type,birthday);

        result.add(client);
      }
      resultSet.close();
      statement.close();
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }

    return result;
  }

}



