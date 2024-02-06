/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.core.domain.StudentDomain;
import br.com.gymback.persistence.out.mysql.entity.StudentEntity;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = {ContactPersistenceMapper.class})
public interface StudentPersistenceMapper
    extends PagingPersistenceMapper<StudentDomain, StudentEntity> {
  StudentEntity toEntity(final StudentDomain student);

  StudentDomain toDomain(final StudentEntity studentEntity);

  @InheritConfiguration
  List<StudentDomain> fromEntityList(final List<StudentEntity> sources);
}
