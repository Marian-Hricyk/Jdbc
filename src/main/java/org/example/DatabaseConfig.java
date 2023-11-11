package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

  @Value("${postgres.db.host}")
  private String host;

  @Value("${postgres.db.port}")
  private String port;

  @Value("${postgres.db.database}")
  private String database;

  @Value("${postgres.db.username}")
  private String username;

  @Value("${postgres.db.password}")
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
}
