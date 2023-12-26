package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gymback.core.domain.Schedule;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.ScheduleEntity;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.WeekDayEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface SchedulePersistenceMapper {

  @Mapping(source = "weekDay", target = "weekDay", qualifiedByName = "weekDayToString")
  Schedule toDomain(final ScheduleEntity source);

  @Mapping(source = "weekDay", target = "weekDay", qualifiedByName = "weekDayToEntity")
  ScheduleEntity toEntity(final Schedule source);

  @Named("weekDayToString")
  default String weekDayToString(final WeekDayEntity weekDayEntity) {
    if (weekDayEntity == null) {
      return null;
    }

    return weekDayEntity.getName();
  }

  @Named("weekDayToEntity")
  default WeekDayEntity weekDayToEntity(final String weekDay) {
    if (weekDay == null) {
      return null;
    }

    return new WeekDayEntity(weekDay, null);

  }

}
