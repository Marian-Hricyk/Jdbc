package org.example;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseQueryService {

  DatabaseConfig databaseConfig = new DatabaseConfig();


  public List<MaxProjectCountClient> findMaxProjectsClient() {
    List<MaxProjectCountClient> result = new ArrayList<>();

    try (Connection connection = databaseConfig.getDatabaseConnection()) {
      try (BufferedReader reader = new BufferedReader(new FileReader("sql/find_max_projects_client.sql"))) {
        StringBuilder query = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
          query.append(line).append(" ");
        }


       try (Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(toString())){

          while (resultSet.next()) {
            String name = resultSet.getString("NAME");
            int projectCount = resultSet.getInt("PROJECT_COUNT");
            result.add(new MaxProjectCountClient(name, projectCount));
          }
        }
      }
    } catch (IOException | SQLException e) {
      e.printStackTrace();
    }

    return result;
  }

  public List<ProjectPrices> printProjectprices() {
    List<ProjectPrices> result = new ArrayList<>();

    try (Connection connection = databaseConfig.getDatabaseConnection()) {
      try (BufferedReader reader = new BufferedReader(new FileReader("sql/print_project_prices.sql"))) {
        StringBuilder query = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
          query.append(line).append(" ");
        }

        try (Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(query.toString())) {

          while (resultSet.next()) {
            int id = resultSet.getInt("PROJECT_ID");
            String startDateStr = resultSet.getString("START_DATE");
            java.sql.Date startDate = java.sql.Date.valueOf(startDateStr);
            String finishDateStr = resultSet.getString("FINISH_DATE");
            java.sql.Date finishDate = java.sql.Date.valueOf(finishDateStr);
            int cost = resultSet.getInt("PROJECT_COST");
            result.add(new ProjectPrices(id, startDate, finishDate, cost));
          }
        }
      }
    } catch (IOException | SQLException e) {
      e.printStackTrace();
    }

    return result;
  }


  public List<MaxSalaryWorker> findMaxSalaryWorkers() {
    List<MaxSalaryWorker> result = new ArrayList<>();

    try (Connection connection = databaseConfig.getDatabaseConnection()) {
      try (BufferedReader reader = new BufferedReader(new FileReader("sql/find_max_salary_worker.sql"))) {
        StringBuilder query = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
          query.append(line).append(" ");
        }

        try (Statement statement=connection.createStatement();
             ResultSet resultSet=statement.executeQuery(query.toString())) {

          while (resultSet.next()) {
            int salary = resultSet.getInt("SALARY");
            String name = resultSet.getString("NAME");
            result.add(new MaxSalaryWorker(salary, name));
          }
        }
      }
    } catch (IOException | SQLException e) {
      e.printStackTrace();
    }

    return result;
  }


  public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
    List<YoungestEldestWorkers> result = new ArrayList<>();

    try (Connection connection = databaseConfig.getDatabaseConnection()) {
      try (BufferedReader reader = new BufferedReader(new FileReader("sql/find_youngest_eldest_workers.sql"))) {
        StringBuilder query = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
          query.append(line).append(" ");
        }

        try (Statement statement=connection.createStatement();
             ResultSet resultSet=statement.executeQuery(query.toString())) {

          while (resultSet.next()) {
            String birthdayStr = resultSet.getString("BIRTHDAY");
            java.sql.Date birthday = java.sql.Date.valueOf(birthdayStr);
            String name = resultSet.getString("NAME");
            String type = resultSet.getString("Typ");
            result.add(new YoungestEldestWorkers(name, type, birthday));
          }
        }
      }
    } catch (IOException | SQLException e) {
      e.printStackTrace();
    }

    return result;
  }


}



