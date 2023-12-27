package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gymback.core.domain.ClassRoom;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.ClassRoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = {
        TeacherPersistenceMapper.class,
        ModalityPersistenceMapper.class,
        SchedulePersistenceMapper.class
    }
)
public interface ClassRoomPersistenceMapper {

  ClassRoomEntity from(final ClassRoom classRoom);

  @Mapping(target = "withModality", ignore = true)
  @Mapping(target = "withTeacher", ignore = true)
  @Mapping(target = "withSchedule", ignore = true)
  ClassRoom from(final ClassRoomEntity classRoomEntity);

}
