package org.example;

public class YoungestEldestWorkers {
  private String name;
  private String type;
  private java.sql.Date birthday;

  public YoungestEldestWorkers(String name, String type,java.sql.Date birthday ){
    this.birthday=birthday;
    this.type=type;
    this.name=name;
  }
}
