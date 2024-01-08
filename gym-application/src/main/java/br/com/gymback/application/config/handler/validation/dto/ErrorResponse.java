package br.com.gymback.application.config.handler.validation.dto;

public record ErrorResponse(
    Integer code,
    String message
) {

}
