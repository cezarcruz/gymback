package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.ModalityDomain;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateModalityRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.UpdateModalityRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.ModalityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface ModalityMapper {

  @Mapping(target = "id", ignore = true)
  ModalityDomain toModality(final CreateModalityRequest createModalityRequest);

  ModalityResponse from(final ModalityDomain createdModality);

  ModalityDomain toModality(final String id, final UpdateModalityRequest updateModalityRequest);
}
