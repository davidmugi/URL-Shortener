package com.example.URLShortener.configuration.execption;

public class UrlNotFoundException extends RuntimeException{

  public UrlNotFoundException(final String message) {
    super(message);
  }
}
