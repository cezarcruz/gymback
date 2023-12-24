package br.com.cezarcruz.gymback.gateway.in.rest.dto.response;

import java.util.List;

public record StudentResponse(
    String id,
    String name,
    Integer age,
    List<ContactResponse> contacts,
    AddressResponse address
) {

}
