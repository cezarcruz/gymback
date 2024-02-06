/* Under MIT License (C)2024 */
package br.com.gymback.application.rest.mapper;

import br.com.gymback.application.rest.dto.request.CreateStudentRequest;
import br.com.gymback.application.rest.dto.response.PageResponse;
import br.com.gymback.application.rest.dto.response.StudentResponse;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.domain.StudentDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = {ContactMapper.class, AddressMapper.class})
public interface StudentMapper extends PagingMapper<StudentDomain> {

  @Mapping(target = "id", ignore = true)
  StudentDomain toStudent(final CreateStudentRequest source);

  StudentResponse from(final StudentDomain student);

  PageResponse<StudentResponse> fromPageDomain(final PageDomain<StudentDomain> teacher);
}
