package org.example;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
    List <MaxSalaryWorker> maxSalaryWorker=new DatabaseQueryService().findMaxSalaryWorkers();
    List<YoungestEldestWorkers> youngestEldestWorkers=new DatabaseQueryService().findYoungestEldestWorkers();
    List<ProjectPrices> projectPrices=new DatabaseQueryService().printProjectprices();
  }
}