package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.Contact;
import br.com.cezarcruz.gymback.core.domain.Student;
import br.com.cezarcruz.gymback.core.enums.ContactType;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateContactRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateStudentRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.StudentResponse;
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
  Student toStudent(final CreateStudentRequest source);

  StudentResponse from(final Student student);


  @Named("fromContactRequest")
  default List<Contact> fromContactRequest(final CreateContactRequest source) {
    var email = new Contact(null, ContactType.EMAIL, source.email());
    var phone = new Contact(null, ContactType.PHONE, source.phone());

    return List.of(email, phone);
  }

}
