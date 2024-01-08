package br.com.gymback.application.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record CreateStudentRequest(

    @NotNull String name,
    @NotNull @JsonFormat(pattern = "dd/MM/yyyy") LocalDate birthDate,
    String document,
    @Valid @NotNull CreateAddressRequest address,

    @Valid @NotNull CreateContactRequest contact

) {

}
