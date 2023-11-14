package org.example;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

  @Value("postgres.db.host")
  private String host;

  @Value("postgres.db.port")
  private String port;

  @Value("postgres.db.database")
  private String database;

  @Value("postgres.db.username")
  private String username;

  @Value("postgres.db.password")
  private String password;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://" + host + ":" + port + "/" + database);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
  public void printDatabaseProperties() {
    System.out.println("Host: " + host);
    System.out.println("Port: " + port);
    System.out.println("Database: " + database);
    System.out.println("Username: " + username);
    System.out.println("Password: " + password);
  }
  public void flyli(){
   // DriverManagerDataSource dataSource = new DriverManagerDataSource();
    String url= "jdbc:postgresql://" + host + ":" + port + "/" + database;
    Flyway flyway = Flyway.configure().dataSource(url,
            username, password).load();
    flyway.migrate();
  }
  public Connection getDatabaseConnection() {
    try {
      String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
      return DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
      throw new RuntimeException("Failed to establish a database connection", e);
    }
  }
}

