package br.com.gymback.application.rest.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record CreateTeacherRequest(
    @NotNull
    String name,
    LocalDate birthDate,
    CreateContactRequest contact
) {

}
