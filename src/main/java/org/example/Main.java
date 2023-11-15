package org.example;


import java.util.List;

public class Main {
  public static void main(String[] args) {
   /* DatabaseConfig databaseConfig = new DatabaseConfig();
    databaseConfig.printDatabaseProperties();
    databaseConfig.flyli();*/
    H2Config config = new H2Config();
    config.flyli();

    DatabaseQueryService databaseQueryService = new DatabaseQueryService();

    printList(databaseQueryService.findMaxProjectsClient());
    printList(databaseQueryService.findMaxSalaryWorkers());
    printList(databaseQueryService.findYoungestEldestWorkers());
    printList(databaseQueryService.printProjectprices());
  }

  public static void printList(List<?> list) {
    list.forEach(System.out::println);
  }
}