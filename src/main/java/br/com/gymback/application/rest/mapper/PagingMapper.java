package br.com.gymback.application.rest.mapper;

import br.com.gymback.application.rest.dto.request.GetPagingRequest;
import br.com.gymback.core.domain.PageDomain;

public interface PagingMapper<T> {
  default PageDomain<T> fromRequest(final GetPagingRequest source) {
    return new PageDomain<>(source.page(), source.size());
  }

}
