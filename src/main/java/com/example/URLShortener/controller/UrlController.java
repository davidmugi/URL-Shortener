package com.example.URLShortener.controller;

import com.example.URLShortener.configuration.execption.UrlAlreadyExistException;
import com.example.URLShortener.configuration.execption.UrlNotFoundException;
import com.example.URLShortener.dto.URLDTO;
import com.example.URLShortener.service.UrlServiceInterface;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {

  private final Logger logger = LoggerFactory.getLogger(UrlController.class);

  private final UrlServiceInterface urlServiceInterface;

  public UrlController(final UrlServiceInterface urlServiceInterface) {
    this.urlServiceInterface = urlServiceInterface;
  }

  @PostMapping("create")
  public ResponseEntity<URLDTO> createUrlDTO(final URLDTO urldto) throws UrlAlreadyExistException {
    return ResponseEntity.ok(urlServiceInterface.createUrl(urldto));
  }

  @PostMapping("update")
  public ResponseEntity<URLDTO> updateUrlDTO(final URLDTO urldto) throws UrlNotFoundException {
    return ResponseEntity.ok(urlServiceInterface.updateUrl(urldto));
  }

  @GetMapping("/{shortUrl}")
  public ResponseEntity redirect(HttpServletResponse response,@PathVariable final String shortUrl) throws UrlNotFoundException {
    final String url = urlServiceInterface.hitUrl(shortUrl);
    return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION,url).build();
  }

}
