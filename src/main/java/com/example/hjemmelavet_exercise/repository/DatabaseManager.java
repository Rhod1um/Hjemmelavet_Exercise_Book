package com.example.hjemmelavet_exercise.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

  private static String hostname;
  private static String username;
  private static String password;
  private static Connection connection;

  public static Connection getConnection(){
    hostname = "jdbc:mysql://keasqlian.mysql.database.azure.com";
    username = "justdon";
    password = "Gagagaga123";

    try {
      connection = DriverManager.getConnection(hostname, username, password);

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return connection;
  }

}
