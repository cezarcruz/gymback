package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateTeacherRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.UpdateTeacherRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.TeacherResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = { ContactMapper.class }
)
public interface TeacherMapper {

  @Mapping(target = "id", ignore = true)
  Teacher from(final CreateTeacherRequest createTeacherRequest);
  TeacherResponse from(final Teacher createdTeacher);
  Teacher toTeacher(final String  id, final UpdateTeacherRequest updateTeacherRequest);
}
