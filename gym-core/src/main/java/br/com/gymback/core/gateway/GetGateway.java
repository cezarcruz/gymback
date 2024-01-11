package br.com.gymback.core.gateway;

import br.com.gymback.core.domain.PageDomain;
import java.util.Optional;

public interface GetGateway<T> {
  PageDomain<T> findAll(PageDomain<T> page);
  Optional<T> findById(final Long id);
}
