package com.example.demo.configs;

import lombok.Getter;

@Getter
public class AppConfig {
  private String url = "jdbc:mysql://localhost:3306/spring_demo";
  private String username = "root";
  private String password = "namaewa";
  private String driver = "com.mysql.cj.jdbc.Driver";
}
