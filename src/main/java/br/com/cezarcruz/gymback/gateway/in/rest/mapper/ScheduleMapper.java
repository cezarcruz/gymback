package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.Schedule;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateScheduleRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.ScheduleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface ScheduleMapper {

  ScheduleResponse from(final Schedule source);
  Schedule from(final CreateScheduleRequest source);

}
