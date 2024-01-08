package br.com.gymback.application.config.handler;

import br.com.gymback.application.config.handler.validation.dto.ErrorMessageResponse;
import br.com.gymback.application.config.handler.validation.dto.ErrorResponse;
import br.com.gymback.core.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {

  private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<ErrorMessageResponse> handle(final MethodArgumentNotValidException exception) {
    final var fieldErrors = exception.getBindingResult().getFieldErrors();

    log.error("invalid request received");

    return fieldErrors.stream()
        .map(ErrorMessageResponse::factory)
        .collect(Collectors.toList());

  }

  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  public ErrorResponse handle(final NotFoundException exception) {

    log.error("error trying to get some resource", exception);

    return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
  }

}
