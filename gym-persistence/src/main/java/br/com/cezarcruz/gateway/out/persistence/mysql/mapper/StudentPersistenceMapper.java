package br.com.cezarcruz.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gateway.out.persistence.mysql.entity.StudentEntity;
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
