package br.com.cezarcruz.gymback.gateway.in.rest.dto.response;

import java.time.LocalTime;

public record ScheduleResponse(
    String weekDay,
    LocalTime startHour,
    LocalTime endHour
) {

}
