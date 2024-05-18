package com.example.URLShortener.configuration.execption;

public class UrlAlreadyExistException extends RuntimeException{

  public UrlAlreadyExistException(final String message) {
    super(message);
  }
}
