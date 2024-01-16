package br.com.gymback.application.rest.handler;

import br.com.gymback.application.rest.handler.validation.dto.ErrorMessageResponse;
import br.com.gymback.application.rest.handler.validation.dto.ErrorResponse;
import br.com.gymback.core.exceptions.BusinessException;
import br.com.gymback.core.exceptions.NotFoundException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<ErrorMessageResponse> handle(final MethodArgumentNotValidException exception) {
    final var fieldErrors = exception.getBindingResult().getFieldErrors();

    log.error("invalid request received");

    return fieldErrors.stream()
        .map(ErrorMessageResponse::factory)
        .toList();

  }

  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  public ErrorResponse handle(final NotFoundException exception) {

    log.error("error trying to get some resource", exception);

    return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BusinessException.class)
  public ErrorResponse handle(final BusinessException exception) {
    log.error("business error", exception);
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
  }

  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(RuntimeException.class)
  public ErrorResponse handle(final RuntimeException exception) {
    log.error("unhandled error", exception);
    return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error");
  }

}
