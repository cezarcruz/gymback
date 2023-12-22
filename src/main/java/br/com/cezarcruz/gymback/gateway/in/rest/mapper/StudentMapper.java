package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.Student;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateStudentRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

  Student toStudent(final CreateStudentRequest createStudentRequest);

  StudentResponse from(final Student createdModality);
}
