package br.com.gymback.application.rest.mapper;

import br.com.gymback.application.rest.dto.request.CreateTeacherRequest;
import br.com.gymback.application.rest.dto.request.UpdateTeacherRequest;
import br.com.gymback.application.rest.dto.response.PageResponse;
import br.com.gymback.application.rest.dto.response.TeacherResponse;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.domain.TeacherDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = { ContactMapper.class }
)
public interface TeacherMapper extends PagingMapper<TeacherDomain> {

  @Mapping(target = "id", ignore = true)
  TeacherDomain fromRequest(final CreateTeacherRequest createTeacherRequest);
  TeacherResponse fromDomain(final TeacherDomain createdTeacher);

  PageResponse<TeacherResponse> fromPageDomain(final PageDomain<TeacherDomain> teacher);

  TeacherDomain toTeacher(final String  id, final UpdateTeacherRequest updateTeacherRequest);
}
