package br.com.cezarcruz.gymback.config.handler.validation.dto;

public record ErrorMessageResponse(
        String field,
        String error
) {
}
