package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.core.domain.ClassRoomDomain;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.persistence.out.mysql.entity.ClassRoomEntity;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.springframework.data.domain.Page;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = {
        TeacherPersistenceMapper.class,
        ModalityPersistenceMapper.class,
        SchedulePersistenceMapper.class
    }
)
public interface ClassRoomPersistenceMapper {

  ClassRoomEntity fromDomain(final ClassRoomDomain classRoom);
  ClassRoomDomain fromEntity(final ClassRoomEntity classRoomEntity);

  @InheritConfiguration
  List<ClassRoomDomain> fromEntityList(final List<ClassRoomEntity> sources);

  default PageDomain<ClassRoomDomain> toPageDomain(final PageDomain<ClassRoomDomain> target, final Page<ClassRoomEntity> source) {
    return target.toBuilder()
        .elements(fromEntityList(source.getContent()))
        .totalElements(source.getTotalElements())
        .totalPages(source.getTotalPages())
        .build();
  }

}
