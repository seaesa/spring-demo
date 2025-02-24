package com.example.demo.repositories;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class BaseRepository {
  private static String url = "jdbc:mysql://localhost:3306/spring_demo";
  private static String username = "root";
  private static String password = "namaewa";
  private static String driver = "com.mysql.cj.jdbc.Driver";
  private static Connection connection;

  public static Connection getConnection() {
    if (connection == null) {
      try {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username,
            password);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return connection;
  }
}
