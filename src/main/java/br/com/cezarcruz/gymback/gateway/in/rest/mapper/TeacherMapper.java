package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.Contact;
import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.core.enums.ContactType;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateContactRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateTeacherRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.UpdateTeacherRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.TeacherResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = { ContactMapper.class }
)
public interface TeacherMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "contacts", source = "contact", qualifiedByName = "fromContactRequest")
  Teacher from(final CreateTeacherRequest createTeacherRequest);
  TeacherResponse from(final Teacher createdTeacher);
  Teacher toTeacher(final String  id, final UpdateTeacherRequest updateTeacherRequest);

  @Named("fromContactRequest")
  default List<Contact> fromContactRequest(final CreateContactRequest source) {
    var email = new Contact(null, ContactType.EMAIL, source.email());
    var phone = new Contact(null, ContactType.PHONE, source.phone());

    return List.of(email, phone);
  }
}
