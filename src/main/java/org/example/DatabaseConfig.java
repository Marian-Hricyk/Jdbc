package org.example;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class DatabaseConfig {
  public DatabaseConfig(){
  Properties property=new Properties() ;
  try(InputStream resourceStream=Thread.currentThread().getContextClassLoader()
          .getResourceAsStream("application.properties")){
    property.load(resourceStream);
    this.port=property.getProperty("postgres.db.port");
    this.host=property.getProperty("postgres.db.host");
    this.database=property.getProperty("postgres.db.database");
    this.password=property.getProperty("postgres.db.password");
    this.username=property.getProperty("postgres.db.username");

  } catch (IOException e) {
    throw new RuntimeException(e);
  }
}

  private String host;
  private String port;
  private String database;
  private String username;
  private String password;

  public void printDatabaseProperties() {
    System.out.println("Host: " + host);
    System.out.println("Port: " + port);
    System.out.println("Database: " + database);
    System.out.println("Username: " + username);
    System.out.println("Password: " + password);
  }

  public void flyli() {
    // DriverManagerDataSource dataSource = new DriverManagerDataSource();
    String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
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

