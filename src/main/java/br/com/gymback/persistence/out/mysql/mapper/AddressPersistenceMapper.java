/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.core.domain.AddressDomain;
import br.com.gymback.persistence.out.mysql.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.JAKARTA)
public interface AddressPersistenceMapper {

  AddressEntity fromDomain(final AddressDomain address);

  AddressDomain fromEntity(final AddressEntity addressEntity);
}
