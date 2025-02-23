package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {
  StudentRepository studentRepository;

  @Override
  public List<Student> findAll() {
    return studentRepository.findAll();
  }

  @Override
  public Student findById(Integer id) {
    return studentRepository.findById(id);
  }

  @Override
  public Student save(Student student) {
    return studentRepository.save(student);
  }
}
