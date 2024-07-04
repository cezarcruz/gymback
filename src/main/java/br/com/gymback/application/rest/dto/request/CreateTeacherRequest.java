/* Under MIT License (C)2024 */
package br.com.gymback.application.rest.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record CreateTeacherRequest(
    @NotNull String name,
    LocalDate birthDate,
    @Valid
    @NotNull
    CreateContactRequest contact) {}
