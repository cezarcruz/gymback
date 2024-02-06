/* Under MIT License (C)2024 */
package br.com.gymback.application.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;

public record ScheduleResponse(
    String weekDay,
    @JsonFormat(pattern = "HH:mm") @Schema(example = "12:00", description = "Start hour")
        LocalTime startHour,
    @NotNull @JsonFormat(pattern = "HH:mm") @Schema(example = "13:00", description = "End hour")
        LocalTime endHour) {}
