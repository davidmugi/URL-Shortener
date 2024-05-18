package com.example.URLShortener.service;

import com.example.URLShortener.configuration.execption.UrlAlreadyExistException;
import com.example.URLShortener.configuration.execption.UrlNotFoundException;
import com.example.URLShortener.dto.URLDTO;
import com.example.URLShortener.entity.URL;
import com.example.URLShortener.mapper.URLMapper;
import com.example.URLShortener.repository.URLRepository;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.sqids.Sqids;

@Service
public class UrlService implements UrlServiceInterface{

  private final URLMapper urlMapper;

  private final URLRepository urlRepository;

  private final Logger logger = LoggerFactory.getLogger(UrlService.class);

  public UrlService(final URLMapper urlMapper, final URLRepository urlRepository) {
    this.urlMapper = urlMapper;
    this.urlRepository = urlRepository;
  }

  @Override
  public URLDTO createUrl(final URLDTO urldto) throws UrlAlreadyExistException {
    logger.info("UrlService - createUrl : {}", urldto);

    if(urlRepository.findURLByUrl(urldto.getUrl()).isPresent())
      throw new UrlAlreadyExistException("Url already set up");

    final URL url = urlMapper.urlDtoToURL(urldto);

    final String fullUrl = url.getUrl();

    Sqids sqids = Sqids.builder()
        .alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
        .minLength(6)
        .build();

    url.setUrlIdentifier(sqids.encode(Arrays.asList(1L,2L,3L,4L,5L,7L,8L)));
    url.setClickCount(0);
    urlRepository.save(url);

    return urlMapper.urlToUrlDto(url);
  }

  @Override
  public URLDTO updateUrl(final URLDTO urldto) throws UrlNotFoundException {
    logger.info("UrlService - updateUrl : {}", urldto);

    final URL url = urlRepository.findURLById(urldto.getId())
        .orElseThrow(() -> new  UrlNotFoundException("URL not found"));

    url.setUrl(urldto.getUrl());
    urlRepository.save(url);

    return urldto;
  }

  @Override
  public String hitUrl(final String shortUrl) throws UrlNotFoundException {
    logger.info("UrlService - hitUrl : {}", shortUrl);

    final URL urlIdentifierCheck = urlRepository.findURLByUrlIdentifier(shortUrl)
        .orElseThrow(() -> new UrlNotFoundException("URl doesn't exist"));

    return urlIdentifierCheck.getUrl();
  }
}
