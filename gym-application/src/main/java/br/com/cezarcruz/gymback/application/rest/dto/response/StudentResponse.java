package br.com.cezarcruz.gymback.application.rest.dto.response;

import java.time.LocalDate;
import java.util.List;

public record StudentResponse(
    String id,
    String name,
    LocalDate birthDate,
    List<ContactResponse> contacts,
    AddressResponse address
) {

}
