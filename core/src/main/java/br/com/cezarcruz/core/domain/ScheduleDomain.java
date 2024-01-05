package br.com.cezarcruz.core.domain;

import java.time.LocalTime;

public record ScheduleDomain(
    String id,
    String weekDay,
    LocalTime startHour,
    LocalTime endHour
) {

}
