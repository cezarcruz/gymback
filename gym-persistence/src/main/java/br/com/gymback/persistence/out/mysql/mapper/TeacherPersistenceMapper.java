package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.domain.TeacherDomain;
import br.com.gymback.persistence.out.mysql.entity.TeacherEntity;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.springframework.data.domain.Page;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = ContactPersistenceMapper.class
)
public interface TeacherPersistenceMapper {
  TeacherEntity toEntity(final TeacherDomain teacher);
  TeacherDomain toDomain(final TeacherEntity teacher);

  @InheritConfiguration
  List<TeacherDomain> fromEntityList(final List<TeacherEntity> sources);

  default PageDomain<TeacherDomain> toPageDomain(final PageDomain<TeacherDomain> target, final Page<TeacherEntity> source) {
    return target.toBuilder()
        .elements(fromEntityList(source.getContent()))
        .totalElements(source.getTotalElements())
        .totalPages(source.getTotalPages())
        .build();
  }
}
