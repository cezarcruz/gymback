package br.com.cezarcruz.gymback.gateway.in.rest.dto.response;

public record AddressResponse(
    Long id,
    String zipCode,
    String street,
    String neighborhood,
    String addressNumber

) {

}
