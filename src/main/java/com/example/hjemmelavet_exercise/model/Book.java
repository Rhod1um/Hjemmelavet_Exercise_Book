package com.example.hjemmelavet_exercise.model;

public class Book {
  private int id;
  private String name, year;

  public Book(int id, String name, String year){
    this.name = name;
    this.year = year;
    this.id = id;
  }
  public Book(String name, String year){
    this.name = name;
    this.year = year;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
