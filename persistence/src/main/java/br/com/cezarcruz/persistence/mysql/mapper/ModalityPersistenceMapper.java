package br.com.cezarcruz.persistence.mysql.mapper;

import br.com.cezarcruz.core.domain.ModalityDomain;
import br.com.cezarcruz.persistence.mysql.entity.ModalityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.JAKARTA)
public interface ModalityPersistenceMapper {

  ModalityEntity from(final ModalityDomain modality);

  ModalityDomain from(final ModalityEntity modalityEntity);
}
