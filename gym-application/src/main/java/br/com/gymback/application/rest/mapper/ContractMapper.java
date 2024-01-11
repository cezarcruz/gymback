package br.com.gymback.application.rest.mapper;

import br.com.gymback.application.rest.dto.response.ContractResponse;
import br.com.gymback.core.domain.ClassRoomDomain;
import br.com.gymback.core.domain.ContractDomain;
import br.com.gymback.core.domain.StudentDomain;
import br.com.gymback.application.rest.dto.request.CreateContractRequest;
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
  default StudentDomain stringToStudent(final Long studentId) {

    if (Objects.isNull(studentId)) {
      return null;
    }

    return StudentDomain.builder().id(studentId).build();

  }

  @Named("stringToClassRoom")
  default ClassRoomDomain stringToClassRoom(final Long classRoomId) {
    if (Objects.isNull(classRoomId)) {
      return null;
    }

    return ClassRoomDomain.builder().id(classRoomId).build();
  }

  ContractResponse fromModel(ContractDomain source);
}
