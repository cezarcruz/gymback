package br.com.cezarcruz.application.rest.mapper;

import br.com.cezarcruz.application.rest.dto.request.CreateContactRequest;
import br.com.cezarcruz.application.rest.dto.request.UpdateContactRequest;
import br.com.cezarcruz.application.rest.dto.response.ContactResponse;
import br.com.cezarcruz.core.domain.ContactDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface ContactMapper {

  @Mapping(target = "id", ignore = true)
  ContactDomain from(final CreateContactRequest source);

  ContactResponse from(final ContactDomain source);

  @Mapping(target = "id", ignore = true)
  ContactDomain from(final UpdateContactRequest source);

}
