package org.example;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class H2Config {

  static final String JDBC_DRIVER = "org.h2.Driver";
  static final String DB_URL = "jdbc:h2:./test";

  static final String USER = "sa";
  static final String PASS = "";

  public Connection getConections() {
    try {
      return DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void flyli() {


    Flyway flyway = Flyway.configure().dataSource(DB_URL,
            USER, PASS).load();
    flyway.migrate();
  }
}

