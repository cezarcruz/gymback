package br.com.cezarcruz.gymback.application.rest.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

public record CreateClassRoomRequest (
    String name,

    @NotNull
    String teacher,

    @NotNull
    String modality,

    @NotNull
    @Positive
    BigDecimal value,

    @Valid
    @NotEmpty
    List<CreateScheduleRequest> schedule
) {

}
