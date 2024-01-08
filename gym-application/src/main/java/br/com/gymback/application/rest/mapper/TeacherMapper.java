package br.com.gymback.application.rest.mapper;

import br.com.gymback.application.rest.dto.request.CreateContactRequest;
import br.com.gymback.application.rest.dto.request.CreateTeacherRequest;
import br.com.gymback.application.rest.dto.request.UpdateTeacherRequest;
import br.com.gymback.application.rest.dto.response.PageResponse;
import br.com.gymback.application.rest.dto.response.TeacherResponse;
import br.com.gymback.core.domain.ContactDomain;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.domain.TeacherDomain;
import br.com.gymback.core.enums.ContactType;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = { ContactMapper.class }
)
public interface TeacherMapper extends PagingMapper<TeacherDomain> {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "contacts", source = "contact", qualifiedByName = "fromContactRequest")
  TeacherDomain fromRequest(final CreateTeacherRequest createTeacherRequest);
  TeacherResponse fromDomain(final TeacherDomain createdTeacher);

  PageResponse<TeacherResponse> fromPageDomain(final PageDomain<TeacherDomain> teacher);

  TeacherDomain toTeacher(final String  id, final UpdateTeacherRequest updateTeacherRequest);

  @Named("fromContactRequest")
  default List<ContactDomain> fromContactRequest(final CreateContactRequest source) {
    var email = new ContactDomain(null, ContactType.EMAIL, source.email());
    var phone = new ContactDomain(null, ContactType.PHONE, source.phone());

    return List.of(email, phone);
  }
}
