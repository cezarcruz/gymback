package br.com.cezarcruz.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gateway.out.persistence.mysql.entity.ScheduleEntity;
import br.com.cezarcruz.gateway.out.persistence.mysql.entity.WeekDayEntity;
import br.com.cezarcruz.gymback.core.domain.ScheduleDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface SchedulePersistenceMapper {

  @Mapping(source = "weekDay", target = "weekDay", qualifiedByName = "weekDayToString")
  ScheduleDomain toDomain(final ScheduleEntity source);

  @Mapping(source = "weekDay", target = "weekDay", qualifiedByName = "weekDayToEntity")
  ScheduleEntity toEntity(final ScheduleDomain source);

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
