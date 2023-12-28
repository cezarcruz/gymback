package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.Contract;
import br.com.cezarcruz.gymback.core.domain.Student;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateContractRequest;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface ContractMapper {

  @Mapping(source = "students", target = "students", qualifiedByName = "stringToModel")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "contractStatus", ignore = true)
  @Mapping(target = "payments", ignore = true)
  Contract fromCreateRequest(final CreateContractRequest source);

  @Named("stringToModel")
  default List<Student> stringToModel(final List<String> list) {

    if (Objects.isNull(list)) {
      return null;
    }

    return list.stream()
        .map(item -> Student.builder().id(item).build())
        .collect(Collectors.toList());

  }

}
