package br.com.cezarcruz.gymback.gateway.in.rest.dto.response;

public record AddressResponse(
    String id,
    String zipcode,
    String street,
    String neighborhood,
    String addressNumber,
    String state,
    String city

) {

}
