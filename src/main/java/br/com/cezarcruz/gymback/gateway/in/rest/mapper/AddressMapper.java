package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.Address;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateAddressRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.AddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface AddressMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "addressNumber", source = "num")
  Address from(final CreateAddressRequest source);
  AddressResponse from(final Address source);
}