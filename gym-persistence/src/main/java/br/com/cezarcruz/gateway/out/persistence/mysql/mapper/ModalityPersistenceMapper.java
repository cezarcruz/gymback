package br.com.cezarcruz.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gateway.out.persistence.mysql.entity.ModalityEntity;
import br.com.cezarcruz.gymback.core.domain.ModalityDomain;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.JAKARTA)
public interface ModalityPersistenceMapper {

  ModalityEntity from(final ModalityDomain modality);

  ModalityDomain from(final ModalityEntity modalityEntity);
}
