package com.example.demo.repositories;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Student;

@Repository
public class StudentRepository {
  private final List<Student> students = new ArrayList<>(
      Arrays.asList(
          new Student(1, "Đặng Ngọc Hải", 12),
          new Student(2, "Nguyễn Văn Nam", 234),
          new Student(3, "Đặng Văn Bịp", 2344)));

  public List<Student> findAll() {
    return students;
  }

  public Student findById(Integer id) {
    return students.stream().filter(student -> student.getId() == id).collect(Collectors.toList()).getFirst();
  }

  public Student save(Student student) {
    students.add(student);
    return student;
  }
}
