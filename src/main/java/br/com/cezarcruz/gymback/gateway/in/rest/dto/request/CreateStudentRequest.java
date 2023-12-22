package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CreateStudentRequest(

    @NotNull String name,
    @NotNull Integer age,
    @Email String email,
    @Valid @NotNull CreateAddressRequest address

) {

}
