package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.persistence.out.mysql.entity.StudentEntity;
import br.com.gymback.core.domain.StudentDomain;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = { ContactPersistenceMapper.class }
)
public interface StudentPersistenceMapper {
  StudentEntity from(final StudentDomain student);
  StudentDomain from(final StudentEntity studentEntity);
}
