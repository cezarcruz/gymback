package br.com.cezarcruz.gymback.application.rest.mapper;

import br.com.cezarcruz.gymback.application.rest.dto.request.CreateContactRequest;
import br.com.cezarcruz.gymback.application.rest.dto.request.CreateStudentRequest;
import br.com.cezarcruz.gymback.application.rest.dto.response.StudentResponse;
import br.com.gymback.core.domain.ContactDomain;
import br.com.gymback.core.domain.StudentDomain;
import br.com.gymback.core.enums.ContactType;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = { ContactMapper.class, AddressMapper.class}
)
public interface StudentMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "contacts", source = "contact", qualifiedByName = "fromContactRequest")
  StudentDomain toStudent(final CreateStudentRequest source);

  StudentResponse from(final StudentDomain student);


  @Named("fromContactRequest")
  default List<ContactDomain> fromContactRequest(final CreateContactRequest source) {
    var email = new ContactDomain(null, ContactType.EMAIL, source.email());
    var phone = new ContactDomain(null, ContactType.PHONE, source.phone());

    return List.of(email, phone);
  }

}
