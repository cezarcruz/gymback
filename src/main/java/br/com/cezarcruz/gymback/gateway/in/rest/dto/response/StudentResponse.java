package br.com.cezarcruz.gymback.gateway.in.rest.dto.response;

public record StudentResponse(
    String id,
    String name,
    Integer age,
    String email,
    AddressResponse address
) {

}
