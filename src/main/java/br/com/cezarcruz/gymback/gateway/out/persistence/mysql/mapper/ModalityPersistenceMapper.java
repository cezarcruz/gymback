package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;


import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.ModalityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.JAKARTA)
public interface ModalityPersistenceMapper {

  ModalityEntity from(final Modality modality);

  Modality from(final ModalityEntity modalityEntity);
}
