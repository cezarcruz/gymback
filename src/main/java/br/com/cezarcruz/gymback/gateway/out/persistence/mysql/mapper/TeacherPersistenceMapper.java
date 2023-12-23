package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.JAKARTA, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeacherPersistenceMapper {
  TeacherEntity from(final Teacher teacher);
  Teacher from(final TeacherEntity teacher);
}
