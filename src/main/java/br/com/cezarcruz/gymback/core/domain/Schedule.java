package br.com.cezarcruz.gymback.core.domain;

import java.time.LocalTime;

public record Schedule (
    String id,
    String weekDay,
    LocalTime startHour,
    LocalTime endHour
) {

}
