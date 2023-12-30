package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record CreateStudentRequest(

    @NotNull String name,
    @NotNull LocalDate birthDate,
    String document,
    @Valid @NotNull CreateAddressRequest address,

    @Valid @NotEmpty CreateContactRequest contact

) {

}
