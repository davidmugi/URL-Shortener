package com.example.URLShortener.repository;

import com.example.URLShortener.entity.URL;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRepository extends JpaRepository<URL, UUID> {

  Optional<URL> findURLByUrlIdentifier(String urlIdentifier);

  Optional<URL> findURLById(UUID id);

  Optional<URL> findURLByUrl(String url);
}
