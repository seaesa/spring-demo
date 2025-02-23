package com.example.demo.services;

import com.example.demo.models.Student;

import java.util.List;

public interface IStudentService {
  List<Student> findAll();

  public Student findById(Integer id);

  Student save(Student student);
}
