package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gymback.core.domain.ClassRoom;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.ClassRoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {TeacherPersistenceMapper.class, ModalityPersistenceMapper.class}
)
public interface ClassRoomPersistenceMapper {

  ClassRoomEntity from(final ClassRoom classRoom);
  ClassRoom from(final ClassRoomEntity classRoomEntity);

}
