/* Under MIT License (C)2024 */
package br.com.gymback.core.domain;

import java.time.LocalTime;

public record ScheduleDomain(Long id, String weekDay, LocalTime startHour, LocalTime endHour) {}
