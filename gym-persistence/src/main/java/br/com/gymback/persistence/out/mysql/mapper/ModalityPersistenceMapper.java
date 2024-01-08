package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.persistence.out.mysql.entity.ModalityEntity;
import br.com.gymback.core.domain.ModalityDomain;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.JAKARTA)
public interface ModalityPersistenceMapper {

  ModalityEntity from(final ModalityDomain modality);

  ModalityDomain from(final ModalityEntity modalityEntity);
}
