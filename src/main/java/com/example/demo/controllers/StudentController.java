package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.IStudentService;
import com.example.demo.utils.ApiResponse;

import java.util.*;

import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
  private final IStudentService studentService;

  @GetMapping
  public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
    return ResponseEntity.ok(ApiResponse.<List<Student>>builder().data(studentService.findAll()).build());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable Integer id) {
    Student student = studentService.findById(id);

    return ResponseEntity.ok(ApiResponse.<Student>builder().data(student).build());
  }

  @PostMapping
  public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody Student student) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(ApiResponse.<Student>builder()
            .data(studentService.save(student)).build());
  }

}
