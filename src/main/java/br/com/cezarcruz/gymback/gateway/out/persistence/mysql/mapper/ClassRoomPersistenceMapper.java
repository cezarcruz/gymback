package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gymback.core.domain.ClassRoom;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.ClassRoomEntity;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.WeekDayEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {TeacherPersistenceMapper.class, ModalityPersistenceMapper.class}
)
public interface ClassRoomPersistenceMapper {

  @Mapping(source = "weekDays", target = "weekDays", qualifiedByName = "weekDaysToEntity")
  ClassRoomEntity from(final ClassRoom classRoom);

  @Mapping(source = "weekDays", target = "weekDays", qualifiedByName = "weekDaysToString")
  ClassRoom from(final ClassRoomEntity classRoomEntity);

  @Named("weekDaysToString")
  default List<String> weekDaysToString(final List<WeekDayEntity> weekDayEntityList) {
    if (weekDayEntityList == null) {
      return null;
    }

    return weekDayEntityList.stream()
        .map(WeekDayEntity::getName)
        .collect(Collectors.toList());
  }

  @Named("weekDaysToEntity")
  default List<WeekDayEntity> weekDaysToEntity(final List<String> list) {
    if (list == null) {
      return null;
    }

    return list.stream()
        .map(l -> new WeekDayEntity(l, null))
        .collect(Collectors.toList());

  }

}
