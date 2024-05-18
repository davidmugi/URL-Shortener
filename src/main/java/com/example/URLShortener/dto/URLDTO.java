package com.example.URLShortener.dto;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class URLDTO {

  private UUID id;

  private String url;

  private String urlIdentifier;

  private Timestamp createdDate;

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("URLDTO{");
    sb.append("id=").append(id);
    sb.append(", url='").append(url).append('\'');
    sb.append(", urlIdentifier='").append(urlIdentifier).append('\'');
    sb.append(", createdDate=").append(createdDate);
    sb.append('}');
    return sb.toString();
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final URLDTO urldto)) {
      return false;
    }

    if (!Objects.equals(id, urldto.id)) {
      return false;
    }
    if (!Objects.equals(url, urldto.url)) {
      return false;
    }
    if (!Objects.equals(urlIdentifier, urldto.urlIdentifier)) {
      return false;
    }
    return Objects.equals(createdDate, urldto.createdDate);
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
