package br.com.cezarcruz.application.rest.mapper;

import br.com.cezarcruz.application.rest.dto.request.CreateClassRoomRequest;
import br.com.cezarcruz.application.rest.dto.response.ClassRoomResponse;
import br.com.cezarcruz.core.domain.ClassRoomDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = {
        ModalityMapper.class,
        TeacherMapper.class,
        ScheduleMapper.class
    }
)
public interface ClassRoomMapper {

  @Mapping(target = "teacher.id", source = "teacher")
  @Mapping(target = "modality.id", source = "modality")
  @Mapping(target = "id", ignore = true)
  ClassRoomDomain from(final CreateClassRoomRequest createClassRoomRequest);
  ClassRoomResponse from(final ClassRoomDomain classRoom);

}
