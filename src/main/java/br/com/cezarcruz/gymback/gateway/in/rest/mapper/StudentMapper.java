package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.Student;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateStudentRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = { ContactMapper.class, AddressMapper.class}
)
public interface StudentMapper {

  @Mapping(target = "id", ignore = true)
  Student toStudent(final CreateStudentRequest createStudentRequest);

  StudentResponse from(final Student student);
}
