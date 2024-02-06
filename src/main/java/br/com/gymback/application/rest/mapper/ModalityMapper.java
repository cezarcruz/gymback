/* Under MIT License (C)2024 */
package br.com.gymback.application.rest.mapper;

import br.com.gymback.application.rest.dto.request.CreateModalityRequest;
import br.com.gymback.application.rest.dto.request.UpdateModalityRequest;
import br.com.gymback.application.rest.dto.response.ModalityResponse;
import br.com.gymback.application.rest.dto.response.PageResponse;
import br.com.gymback.core.domain.ModalityDomain;
import br.com.gymback.core.domain.PageDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.JAKARTA)
public interface ModalityMapper extends PagingMapper<ModalityDomain> {

  @Mapping(target = "id", ignore = true)
  ModalityDomain toModality(final CreateModalityRequest createModalityRequest);

  ModalityResponse toModalityResponse(final ModalityDomain createdModality);

  ModalityDomain toModality(final String id, final UpdateModalityRequest updateModalityRequest);

  PageResponse<ModalityResponse> fromPageDomain(final PageDomain<ModalityDomain> source);
}
