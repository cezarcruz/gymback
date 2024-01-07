package br.com.cezarcruz.gymback.application.rest.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateAddressRequest(
    @NotNull
    String zipcode,
    @NotNull
    String street,
    @NotNull
    String neighborhood,
    @NotNull
    String num,
    String state,
    String city
) {

}
