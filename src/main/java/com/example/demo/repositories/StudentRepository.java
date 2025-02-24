package com.example.demo.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Student;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class StudentRepository {
  private final List<Student> students;

  public List<Student> findAll() {
    try {
      PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("select * from student");
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        students.add(Student.builder()
            .id(resultSet.getInt("id"))
            .name(resultSet.getString("name"))
            .score(resultSet.getDouble("score"))
            .build());
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return students;
  }

  public Student findById(Integer id) {
    try {
      PreparedStatement preparedStatement = BaseRepository.getConnection()
          .prepareStatement("select * from student where id = ?");
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        return Student.builder()
            .id(resultSet.getInt("id"))
            .name(resultSet.getString("name"))
            .score(resultSet.getDouble("score"))
            .build();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
  }

  public Student save(Student student) {
    try {
      PreparedStatement preparedStatement = BaseRepository.getConnection()
          .prepareStatement("insert into student (name,score) values (?,?)");
      preparedStatement.setString(1, student.getName());
      preparedStatement.setDouble(2, student.getScore());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return student;
  }
}
