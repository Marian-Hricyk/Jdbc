package org.example;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class DatabaseQueryService {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public DatabaseQueryService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }




  public List<MaxProjectCountClient> findMaxProjectsClient() {
    List<MaxProjectCountClient> result = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("sql/find_max_projects_client.sql"));
      StringBuilder query = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        query.append(line).append(" ");
      }

      List<MaxProjectCountClient> clients = jdbcTemplate.query(query.toString(), new RowMapper<MaxProjectCountClient>() {
        @Override
        public MaxProjectCountClient mapRow(ResultSet resultSet, int rowNum) throws SQLException {
          String name = resultSet.getString("NAME");
          int projectCount = resultSet.getInt("PROJECT_COUNT");
          return new MaxProjectCountClient(name, projectCount);
        }
      });


      result.addAll(clients);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }

  public List<ProjectPrices> printProjectprices() {
    List<ProjectPrices> result = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("sql/print_project_prices.sql"));
      StringBuilder query = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        query.append(line).append(" ");
      }

      List<ProjectPrices> clients = jdbcTemplate.query(query.toString(), new RowMapper<ProjectPrices>() {
        @Override
        public ProjectPrices mapRow(ResultSet resultSet, int rowNum) throws SQLException {
          int id = resultSet.getInt("PROJECT_ID");
          String Str = resultSet.getString("START_DATE");
          java.sql.Date Start = java.sql.Date.valueOf(Str);
          String finish = resultSet.getString("FINISH_DATE");
          java.sql.Date Finish = java.sql.Date.valueOf(finish);
          int cost = resultSet.getInt("PROJECT_COST");
          return new ProjectPrices(id, Start, Finish, cost);
        }
      });

      result.addAll(clients);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }


  public List<MaxSalaryWorker> findMaxSalaryWorkers() {
    List<MaxSalaryWorker> result = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("sql/find_max_salary_worker.sql"));
      StringBuilder query = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        query.append(line).append(" ");
      }
      reader.close();

      List<MaxSalaryWorker> workers = jdbcTemplate.query(query.toString(), new RowMapper<MaxSalaryWorker>() {
        @Override
        public MaxSalaryWorker mapRow(ResultSet resultSet, int rowNum) throws SQLException {
          int salary = resultSet.getInt("SALARY");
          String name = resultSet.getString("NAME");
          return new MaxSalaryWorker(salary, name);
        }
      });

      result.addAll(workers);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }


  public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
    List<YoungestEldestWorkers> result = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("sql/find_youngest_eldest_workers.sql"));
      StringBuilder query = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        query.append(line).append(" ");
      }

      List<YoungestEldestWorkers> workers = jdbcTemplate.query(query.toString(), new RowMapper<YoungestEldestWorkers>() {
        @Override
        public YoungestEldestWorkers mapRow(ResultSet resultSet, int rowNum) throws SQLException {
          String birthdayStr = resultSet.getString("BIRTHDAY");
          java.sql.Date birthday = java.sql.Date.valueOf(birthdayStr);
          String name = resultSet.getString("NAME");
          String type = resultSet.getString("Typ");
          return new YoungestEldestWorkers(name, type, birthday);
        }
      });

      result.addAll(workers);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }


}



