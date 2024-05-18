package com.example.URLShortener.service;

import com.example.URLShortener.configuration.execption.UrlAlreadyExistException;
import com.example.URLShortener.configuration.execption.UrlNotFoundException;
import com.example.URLShortener.dto.URLDTO;

public interface UrlServiceInterface {

  URLDTO createUrl(URLDTO urldto) throws UrlAlreadyExistException;

  URLDTO updateUrl(URLDTO urldto) throws UrlNotFoundException;

  String hitUrl(String url) throws UrlNotFoundException;
}
