package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateModalityRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.UpdateModalityRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.ModalityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ModalityMapper {

  Modality toModality(final CreateModalityRequest createModalityRequest);

  ModalityResponse from(final Modality createdModality);

  Modality toModality(final Long id, final UpdateModalityRequest updateModalityRequest);
}
