/* Under MIT License (C)2024 */
package br.com.gymback.application.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record CreateStudentRequest(
    @NotNull @NotBlank String name,
    @NotNull @JsonFormat(pattern = "dd/MM/yyyy") LocalDate birthDate,
    String document,
    @Valid @NotNull CreateAddressRequest address,
    @Valid @NotNull CreateContactRequest contact) {}
