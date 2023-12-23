package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record CreateClassRoomRequest (
    String name,

    @NotNull
    String teacher,

    @NotNull
    String modality,

    @NotEmpty
    List<String> weekDays
) {

}
