package org.example;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class Main {
  public static void main(String[] args) {
DatabaseConfig databaseConfig=new DatabaseConfig();
databaseConfig.printDatabaseProperties();
/*databaseConfig.flyli();
    DatabaseQueryService databaseQueryService=new DatabaseQueryService();

    List<MaxProjectCountClient> maxProjectCountClients = databaseQueryService.findMaxProjectsClient();
    List<MaxSalaryWorker> maxSalaryWorker = databaseQueryService.findMaxSalaryWorkers();
    List<YoungestEldestWorkers> youngestEldestWorkers = databaseQueryService.findYoungestEldestWorkers();
    List<ProjectPrices> projectPrices = databaseQueryService.printProjectprices();
*/
  }
}