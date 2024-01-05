package br.com.cezarcruz.application.rest.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateContactRequest(
    @NotNull
    String email,
    @NotNull
    String phone
) {

}
