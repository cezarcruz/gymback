/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.core.domain.ClassRoomDomain;
import br.com.gymback.persistence.out.mysql.entity.ClassRoomEntity;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = {
      TeacherPersistenceMapper.class,
      ModalityPersistenceMapper.class,
      SchedulePersistenceMapper.class
    })
public interface ClassRoomPersistenceMapper
    extends PagingPersistenceMapper<ClassRoomDomain, ClassRoomEntity> {

  ClassRoomEntity fromDomain(final ClassRoomDomain classRoom);

  ClassRoomDomain fromEntity(final ClassRoomEntity classRoomEntity);

  @InheritConfiguration
  List<ClassRoomDomain> fromEntityList(final List<ClassRoomEntity> sources);
}
