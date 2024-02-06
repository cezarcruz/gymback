package br.com.gymback.application.rest.dto.response;

import java.time.LocalDate;

public record StudentResponse(
    String id,
    String name,
    LocalDate birthDate,
    ContactResponse contact,
    AddressResponse address
) {

}
