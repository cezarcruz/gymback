package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gymback.core.domain.ClassRoomDomain;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.ClassRoomEntity;
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
