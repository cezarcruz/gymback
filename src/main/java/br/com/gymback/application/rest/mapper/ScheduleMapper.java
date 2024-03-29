/* Under MIT License (C)2024 */
package br.com.gymback.application.rest.mapper;

import br.com.gymback.application.rest.dto.request.CreateScheduleRequest;
import br.com.gymback.application.rest.dto.response.ScheduleResponse;
import br.com.gymback.core.domain.ScheduleDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.JAKARTA)
public interface ScheduleMapper {

  ScheduleResponse from(final ScheduleDomain source);

  @Mapping(target = "id", ignore = true)
  ScheduleDomain from(final CreateScheduleRequest source);
}
