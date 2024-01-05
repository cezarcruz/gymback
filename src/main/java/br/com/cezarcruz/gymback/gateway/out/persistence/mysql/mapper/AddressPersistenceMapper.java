package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gymback.core.domain.AddressDomain;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface AddressPersistenceMapper {

  AddressEntity from(final AddressDomain address);
  AddressDomain from(final AddressEntity addressEntity);

}
