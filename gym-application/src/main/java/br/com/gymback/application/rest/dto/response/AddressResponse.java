package br.com.gymback.application.rest.dto.response;

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
