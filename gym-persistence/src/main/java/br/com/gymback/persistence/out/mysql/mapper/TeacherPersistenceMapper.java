package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.persistence.out.mysql.entity.TeacherEntity;
import br.com.gymback.core.domain.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = ContactPersistenceMapper.class
)
public interface TeacherPersistenceMapper {
  TeacherEntity from(final Teacher teacher);
  Teacher from(final TeacherEntity teacher);
}
