/* Under MIT License (C)2024 */
package br.com.gymback.application.rest.handler.validation.dto;

import org.springframework.validation.FieldError;

public record ErrorMessageResponse(String field, String error) {

  public static ErrorMessageResponse factory(final FieldError fieldError) {
    return new ErrorMessageResponse(fieldError.getField(), fieldError.getDefaultMessage());
  }
}
