package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record CreateStudentRequest(

    @NotNull String name,
    @NotNull Integer age,
    @Valid @NotNull CreateAddressRequest address,

    @Valid @NotEmpty List<CreateContactRequest> contacts

) {

}
