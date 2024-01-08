package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.domain.StudentDomain;
import br.com.gymback.persistence.out.mysql.entity.StudentEntity;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.springframework.data.domain.Page;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = { ContactPersistenceMapper.class }
)
public interface StudentPersistenceMapper {
  StudentEntity toEntity(final StudentDomain student);
  StudentDomain toDomain(final StudentEntity studentEntity);

  @InheritConfiguration
  List<StudentDomain> fromEntityList(final List<StudentEntity> sources);

  default PageDomain<StudentDomain> toPageDomain(final PageDomain<StudentDomain> target, final Page<StudentEntity> source) {
    return target.toBuilder()
        .elements(fromEntityList(source.getContent()))
        .totalElements(source.getTotalElements())
        .totalPages(source.getTotalPages())
        .build();
  }

}
