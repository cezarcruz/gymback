package br.com.cezarcruz.persistence.mysql.mapper;

import br.com.cezarcruz.core.domain.Teacher;
import br.com.cezarcruz.persistence.mysql.entity.TeacherEntity;
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
