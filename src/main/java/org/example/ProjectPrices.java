package org.example;

public class ProjectPrices {
  private int id;
  private java.sql.Date start;
  private java.sql.Date finish;
  private int cost;

  public ProjectPrices(int id, java.sql.Date start, java.sql.Date finish, int cost) {
    this.id = id;
    this.start = start;
    this.finish = finish;
    this.cost = cost;
  }
  @Override
  public String toString() {
    return "ProjectPrices{" +
            "id=" + id +
            ", start=" + start +
            ", finish=" + finish +
            ", cost=" + cost +
            '}';
  }
}