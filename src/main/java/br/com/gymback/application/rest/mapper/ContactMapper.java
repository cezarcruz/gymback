/* Under MIT License (C)2024 */
package br.com.gymback.application.rest.mapper;

import br.com.gymback.application.rest.dto.request.CreateContactRequest;
import br.com.gymback.application.rest.dto.request.UpdateContactRequest;
import br.com.gymback.application.rest.dto.response.ContactResponse;
import br.com.gymback.core.domain.ContactDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.JAKARTA)
public interface ContactMapper {

  @Mapping(target = "id", ignore = true)
  ContactDomain from(final CreateContactRequest source);

  ContactResponse from(final ContactDomain source);

  @Mapping(target = "id", ignore = true)
  ContactDomain from(final UpdateContactRequest source);
}
