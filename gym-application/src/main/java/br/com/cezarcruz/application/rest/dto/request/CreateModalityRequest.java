package br.com.cezarcruz.application.rest.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateModalityRequest(
    @NotNull
    String name
) {

}
