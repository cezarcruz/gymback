package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateTeacherRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.UpdateTeacherRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.TeacherResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeacherMapper {
  Teacher from(final CreateTeacherRequest createTeacherRequest);
  TeacherResponse from(final Teacher createdTeacher);
  Teacher toTeacher(final Long id, final UpdateTeacherRequest updateTeacherRequest);
}