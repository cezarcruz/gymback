package br.com.gymback.core.exceptions;

public abstract class NotFoundException extends RuntimeException {

  private final Long id;

  NotFoundException(final Long id) {
    this.id = id;
  }

  @Override
  public String getMessage() {
    return String.format("%s %s not found", getResource(), id);
  }

  public abstract String getResource();
}
