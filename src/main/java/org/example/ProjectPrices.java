package org.example;

public class ProjectPrices {
  private int id;

  private int cost;

  public ProjectPrices(int id,  int cost) {
    this.id = id;
    this.cost = cost;
  }
  @Override
  public String toString() {
    return "ProjectPrices{" +
            "id=" + id +
            ", cost=" + cost +
            '}';
  }
}