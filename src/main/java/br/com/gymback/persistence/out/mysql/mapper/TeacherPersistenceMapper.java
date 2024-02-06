package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.core.domain.TeacherDomain;
import br.com.gymback.persistence.out.mysql.entity.TeacherEntity;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = ContactPersistenceMapper.class
)
public interface TeacherPersistenceMapper extends
    PagingPersistenceMapper<TeacherDomain, TeacherEntity> {
  TeacherEntity toEntity(final TeacherDomain teacher);
  TeacherDomain toDomain(final TeacherEntity teacher);

  @InheritConfiguration
  List<TeacherDomain> fromEntityList(final List<TeacherEntity> sources);
}
