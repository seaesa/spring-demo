package com.example.demo.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exceptions.ApiException;
import com.example.demo.exceptions.ErrorCode;

@ControllerAdvice
public class GlobalHandlerException {
  @ExceptionHandler(ApiException.class)
  public ResponseEntity<?> handleException(ApiException e) {
    ErrorCode errorCode = e.getErrorCode();
    return ResponseEntity.status(errorCode.getStatus()).body(
        ApiResponse.builder()
            .code(errorCode.getCode())
            .message(errorCode.getMessage())
            .build());
  }
}
