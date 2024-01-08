package br.com.gymback.application.rest.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateModalityRequest(
    @NotNull
    String name
) {

}
