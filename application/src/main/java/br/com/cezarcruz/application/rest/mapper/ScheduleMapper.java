package br.com.cezarcruz.application.rest.mapper;

import br.com.cezarcruz.application.rest.dto.request.CreateScheduleRequest;
import br.com.cezarcruz.core.domain.ScheduleDomain;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.ScheduleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface ScheduleMapper {

  ScheduleResponse from(final ScheduleDomain source);

  @Mapping(target = "id", ignore = true)
  ScheduleDomain from(final CreateScheduleRequest source);

}