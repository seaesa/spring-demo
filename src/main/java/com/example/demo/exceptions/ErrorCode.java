package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
  STUDENT_NOT_EXITS(200, "okla", HttpStatus.OK);

  Integer Code;
  String message;
  HttpStatus status;
}
