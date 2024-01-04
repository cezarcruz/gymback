package br.com.cezarcruz.gymback.config.handler;

import br.com.cezarcruz.gymback.config.handler.validation.dto.ErrorMessageResponse;
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

  private final static Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<ErrorMessageResponse> handle(final MethodArgumentNotValidException exception) {
    final var fieldErrors = exception.getBindingResult().getFieldErrors();

    log.error("invalid request received");

    return fieldErrors.stream()
        .map(ErrorMessageResponse::factory)
        .collect(Collectors.toList());

  }

}
