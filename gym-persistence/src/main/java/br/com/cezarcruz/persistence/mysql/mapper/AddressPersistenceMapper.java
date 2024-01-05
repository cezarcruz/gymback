package br.com.cezarcruz.persistence.mysql.mapper;

import br.com.cezarcruz.core.domain.AddressDomain;
import br.com.cezarcruz.persistence.mysql.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface AddressPersistenceMapper {

  AddressEntity from(final AddressDomain address);
  AddressDomain from(final AddressEntity addressEntity);

}
