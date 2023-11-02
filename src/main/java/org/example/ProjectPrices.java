package org.example;

public class ProjectPrices {
  private int id;
  private String start;
  private String finish;
  private int cost;

public ProjectPrices(int id,String start,String finish,int cost){
   this.id=id;
    this.start=start;
    this.finish=finish;
    this.cost=cost;
}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getFinish() {
    return finish;
  }

  public void setFinish(String finish) {
    this.finish = finish;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }
}
