package br.com.cezarcruz.application.rest.mapper;

import br.com.cezarcruz.application.rest.dto.request.CreateContractRequest;
import br.com.cezarcruz.application.rest.dto.response.ContractResponse;
import br.com.cezarcruz.core.domain.ClassRoomDomain;
import br.com.cezarcruz.core.domain.ContractDomain;
import br.com.cezarcruz.core.domain.StudentDomain;
import java.util.Objects;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = PaymentMapper.class
)
public interface ContractMapper {

  @Mapping(source = "student", target = "student", qualifiedByName = "stringToStudent")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "contractStatus", ignore = true)
  @Mapping(target = "payments", ignore = true)
  @Mapping(target = "withStudent", ignore = true)
  @Mapping(target = "classRoom", source = "classRoom", qualifiedByName = "stringToClassRoom")
  ContractDomain fromCreateRequest(final CreateContractRequest source);

  @Named("stringToStudent")
  default StudentDomain stringToStudent(final String studentId) {

    if (Objects.isNull(studentId)) {
      return null;
    }

    return StudentDomain.builder().id(studentId).build();

  }

  @Named("stringToClassRoom")
  default ClassRoomDomain stringToClassRoom(final String classRoomId) {
    if (Objects.isNull(classRoomId)) {
      return null;
    }

    return ClassRoomDomain.builder().id(classRoomId).build();
  }

  ContractResponse fromModel(ContractDomain source);
}
