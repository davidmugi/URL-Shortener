package com.example.URLShortener.configuration.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({UrlNotFoundException.class})
  public ResponseEntity<Object> handleUrlNotFoundException(final UrlNotFoundException urlNotFoundException){
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(urlNotFoundException.getMessage());
  }

  @ExceptionHandler({UrlAlreadyExistException.class})
  public ResponseEntity<Object> handleUrlAlreadyExistException(final UrlAlreadyExistException urlAlreadyExistException){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(urlAlreadyExistException.getMessage());
  }

  @ExceptionHandler({RuntimeException.class})
  public ResponseEntity<Object> handleRuntimeException(final RuntimeException runtimeException){
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Request Failed. Please try again");
  }
}
