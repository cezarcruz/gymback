package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateModalityRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.UpdateModalityRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.ModalityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface ModalityMapper {

  Modality toModality(final CreateModalityRequest createModalityRequest);

  ModalityResponse from(final Modality createdModality);

  Modality toModality(final String id, final UpdateModalityRequest updateModalityRequest);
}
