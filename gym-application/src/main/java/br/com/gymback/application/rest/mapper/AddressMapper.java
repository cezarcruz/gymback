package br.com.gymback.application.rest.mapper;

import br.com.gymback.application.rest.dto.request.CreateAddressRequest;
import br.com.gymback.application.rest.dto.response.AddressResponse;
import br.com.gymback.core.domain.AddressDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface AddressMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "addressNumber", source = "num")
  AddressDomain fromRequest(final CreateAddressRequest source);
  AddressResponse fromDomain(final AddressDomain source);
}
