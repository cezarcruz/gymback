package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.core.domain.GenericDomain;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.persistence.out.mysql.entity.GenericEntity;
import java.util.List;
import org.springframework.data.domain.Page;

public interface PagingPersistenceMapper<D extends GenericDomain, E extends GenericEntity> {

  List<D> fromEntityList(final List<E> sources);

  default PageDomain<D> toPageDomain(final PageDomain<D> target, final Page<E> source) {
    return target.toBuilder()
        .elements(fromEntityList(source.getContent()))
        .totalElements(source.getTotalElements())
        .totalPages(source.getTotalPages())
        .build();
  }
}
