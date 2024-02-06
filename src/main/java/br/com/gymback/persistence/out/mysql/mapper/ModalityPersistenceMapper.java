/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.core.domain.ModalityDomain;
import br.com.gymback.persistence.out.mysql.entity.ModalityEntity;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.JAKARTA)
public interface ModalityPersistenceMapper
    extends PagingPersistenceMapper<ModalityDomain, ModalityEntity> {

  ModalityEntity from(final ModalityDomain modality);

  ModalityDomain from(final ModalityEntity modalityEntity);

  @InheritConfiguration
  List<ModalityDomain> fromEntityList(final List<ModalityEntity> sources);
}
