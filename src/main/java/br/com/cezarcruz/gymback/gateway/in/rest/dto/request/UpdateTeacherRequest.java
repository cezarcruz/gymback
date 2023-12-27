package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public record UpdateTeacherRequest(

    @NotNull
    String name,
    LocalDate birthDate,
    List<UpdateContactRequest> contacts
) {

}
