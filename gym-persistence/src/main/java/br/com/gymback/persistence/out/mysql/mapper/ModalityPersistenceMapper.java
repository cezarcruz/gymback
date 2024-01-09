package br.com.gymback.persistence.out.mysql.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.springframework.data.domain.Page;

import br.com.gymback.core.domain.ModalityDomain;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.persistence.out.mysql.entity.ModalityEntity;

@Mapper(componentModel = ComponentModel.JAKARTA)
public interface ModalityPersistenceMapper {

  ModalityEntity from(final ModalityDomain modality);

  ModalityDomain from(final ModalityEntity modalityEntity);

  @InheritConfiguration
  List<ModalityDomain> fromEntityList(final List<ModalityEntity> sources);

  default PageDomain<ModalityDomain> toPageDomain(final PageDomain<ModalityDomain> target, final Page<ModalityEntity> source) {
    return target.toBuilder()
        .elements(fromEntityList(source.getContent()))
        .totalElements(source.getTotalElements())
        .totalPages(source.getTotalPages())
        .build();
  }}
