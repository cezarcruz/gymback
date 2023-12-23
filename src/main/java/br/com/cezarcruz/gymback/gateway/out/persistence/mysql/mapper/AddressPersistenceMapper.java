package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gymback.core.domain.Address;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.JAKARTA, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressPersistenceMapper {

  AddressEntity from(final Address address);
  Address from(final AddressEntity addressEntity);

}
