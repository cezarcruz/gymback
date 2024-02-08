/* Under MIT License (C)2024 */
package br.com.gymback.core.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.With;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class PageDomain<T> {
  private int page;
  private int size;
  private long totalElements;
  private int totalPages;

  @With
  private List<T> elements;

  public PageDomain(int page, int size) {
    this.page = page;
    this.size = size;
  }
}
