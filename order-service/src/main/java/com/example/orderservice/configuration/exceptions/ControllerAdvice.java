package com.example.orderservice.configuration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {
  
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, String>> exceptionHandler(Exception e) {
    e.fillInStackTrace();
    Map<String, String> message = Collections.singletonMap("message", e.getMessage());
    return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}