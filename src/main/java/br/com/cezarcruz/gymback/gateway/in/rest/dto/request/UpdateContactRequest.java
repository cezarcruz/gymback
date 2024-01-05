package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateContactRequest(
    @NotNull
    String email,
    @NotNull
    String phone
) {

}
