/* Under MIT License (C)2024 */
package br.com.gymback.application.rest.mapper;

import br.com.gymback.application.rest.dto.request.CreateClassRoomRequest;
import br.com.gymback.application.rest.dto.response.ClassRoomResponse;
import br.com.gymback.application.rest.dto.response.PageResponse;
import br.com.gymback.core.domain.ClassRoomDomain;
import br.com.gymback.core.domain.PageDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = {ModalityMapper.class, TeacherMapper.class, ScheduleMapper.class})
public interface ClassRoomMapper extends PagingMapper<ClassRoomDomain> {

  @Mapping(target = "teacher.id", source = "teacher")
  @Mapping(target = "modality.id", source = "modality")
  @Mapping(target = "id", ignore = true)
  ClassRoomDomain from(final CreateClassRoomRequest createClassRoomRequest);

  ClassRoomResponse from(final ClassRoomDomain classRoom);

  PageResponse<ClassRoomResponse> fromPageDomain(final PageDomain<ClassRoomDomain> source);
}
