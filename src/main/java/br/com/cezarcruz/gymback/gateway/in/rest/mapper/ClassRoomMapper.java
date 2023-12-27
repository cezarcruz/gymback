package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.ClassRoom;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateClassRoomRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.ClassRoomResponse;
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
  @Mapping(target = "withModality", ignore = true)
  @Mapping(target = "withTeacher", ignore = true)
  @Mapping(target = "withSchedule", ignore = true)
  @Mapping(target = "id", ignore = true)
  ClassRoom from(final CreateClassRoomRequest createClassRoomRequest);
  ClassRoomResponse from(final ClassRoom classRoom);

}
