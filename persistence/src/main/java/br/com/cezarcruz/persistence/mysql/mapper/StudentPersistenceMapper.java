package br.com.cezarcruz.persistence.mysql.mapper;

import br.com.cezarcruz.core.domain.StudentDomain;
import br.com.cezarcruz.persistence.mysql.entity.StudentEntity;
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