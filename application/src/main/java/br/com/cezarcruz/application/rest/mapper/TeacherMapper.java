package br.com.cezarcruz.application.rest.mapper;

import br.com.cezarcruz.application.rest.dto.request.CreateContactRequest;
import br.com.cezarcruz.application.rest.dto.request.CreateTeacherRequest;
import br.com.cezarcruz.application.rest.dto.request.UpdateTeacherRequest;
import br.com.cezarcruz.application.rest.dto.response.TeacherResponse;
import br.com.cezarcruz.core.domain.ContactDomain;
import br.com.cezarcruz.core.domain.PageDomain;
import br.com.cezarcruz.core.domain.Teacher;
import br.com.cezarcruz.core.enums.ContactType;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.PageResponse;
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
  Teacher fromRequest(final CreateTeacherRequest createTeacherRequest);
  TeacherResponse fromDomain(final Teacher createdTeacher);

  PageResponse<TeacherResponse> fromPageDomain(final PageDomain<Teacher> teacher);

  Teacher toTeacher(final String  id, final UpdateTeacherRequest updateTeacherRequest);

  @Named("fromContactRequest")
  default List<ContactDomain> fromContactRequest(final CreateContactRequest source) {
    var email = new ContactDomain(null, ContactType.EMAIL, source.email());
    var phone = new ContactDomain(null, ContactType.PHONE, source.phone());

    return List.of(email, phone);
  }
}
