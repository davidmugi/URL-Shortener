package com.example.URLShortener.mapper;

import com.example.URLShortener.dto.URLDTO;
import com.example.URLShortener.entity.URL;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface URLMapper {

  URL urlDtoToURL(URLDTO urldto);

  URLDTO urlToUrlDto(URL url);
}
