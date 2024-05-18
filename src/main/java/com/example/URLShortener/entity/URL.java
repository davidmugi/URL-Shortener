package com.example.URLShortener.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

@Entity
@Table(name = "url")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class URL implements Serializable {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;

  private String url;

  private String urlIdentifier;

  private Timestamp createdDate;

  private int clickCount = 0;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final URL url1)) {
      return false;
    }

    if (!Objects.equals(id, url1.id)) {
      return false;
    }
    if (!Objects.equals(url, url1.url)) {
      return false;
    }
    if (!Objects.equals(urlIdentifier, url1.urlIdentifier)) {
      return false;
    }
    return Objects.equals(createdDate, url1.createdDate);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (url != null ? url.hashCode() : 0);
    result = 31 * result + (urlIdentifier != null ? urlIdentifier.hashCode() : 0);
    result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
    return result;
  }
}
