package br.com.cezarcruz.gymback.core.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class PageDomain<T> {
  private int page;
  private int size;
  private List<T> elements;
  private long totalElements;
  private int totalPages;

  public PageDomain(int page, int size) {
    this.page = page;
    this.size = size;
  }

}
