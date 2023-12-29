package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.ClassRoom;
import br.com.cezarcruz.gymback.core.domain.Contract;
import br.com.cezarcruz.gymback.core.domain.Student;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateContractRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.ContractResponse;
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
  Contract fromCreateRequest(final CreateContractRequest source);

  @Named("stringToStudent")
  default Student stringToStudent(final String studentId) {

    if (Objects.isNull(studentId)) {
      return null;
    }

    return Student.builder().id(studentId).build();

  }

  @Named("stringToClassRoom")
  default ClassRoom stringToClassRoom(final String classRoomId) {
    if (Objects.isNull(classRoomId)) {
      return null;
    }

    return ClassRoom.builder().id(classRoomId).build();
  }

  ContractResponse fromModel(Contract source);
}
