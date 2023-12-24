package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.Student;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateStudentRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface StudentMapper {

  Student toStudent(final CreateStudentRequest createStudentRequest);

  StudentResponse from(final Student student);
}
