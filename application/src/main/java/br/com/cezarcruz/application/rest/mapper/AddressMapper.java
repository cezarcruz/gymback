package br.com.cezarcruz.application.rest.mapper;

import br.com.cezarcruz.application.rest.dto.request.CreateAddressRequest;
import br.com.cezarcruz.application.rest.dto.response.AddressResponse;
import br.com.cezarcruz.core.domain.AddressDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface AddressMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "addressNumber", source = "num")
  AddressDomain from(final CreateAddressRequest source);
  AddressResponse from(final AddressDomain source);
}