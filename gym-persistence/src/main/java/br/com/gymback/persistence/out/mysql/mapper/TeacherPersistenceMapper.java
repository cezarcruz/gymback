package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.persistence.out.mysql.entity.TeacherEntity;
import br.com.gymback.core.domain.TeacherDomain;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = ContactPersistenceMapper.class
)
public interface TeacherPersistenceMapper {
  TeacherEntity from(final TeacherDomain teacher);
  TeacherDomain from(final TeacherEntity teacher);
}
