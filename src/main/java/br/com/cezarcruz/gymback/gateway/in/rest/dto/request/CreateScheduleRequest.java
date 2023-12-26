package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalTime;

public record CreateScheduleRequest(
    String weekDay,

    @JsonFormat(pattern = "HH:mm")
    LocalTime startHour,

    @JsonFormat(pattern = "HH:mm")
    LocalTime endHour
) {

}
