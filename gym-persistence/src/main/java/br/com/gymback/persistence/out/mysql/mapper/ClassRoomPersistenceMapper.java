package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.persistence.out.mysql.entity.ClassRoomEntity;
import br.com.gymback.core.domain.ClassRoomDomain;
import org.mapstruct.Mapper;
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

  ClassRoomEntity from(final ClassRoomDomain classRoom);

  ClassRoomDomain from(final ClassRoomEntity classRoomEntity);

}
