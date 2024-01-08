package br.com.gymback.core.exceptions;

public abstract class NotFoundException extends RuntimeException {

  private final String id;

  public NotFoundException(final String id) {
    this.id = id;
  }

  public String getMessage() {
    return String.format("%s %s not found", getResource(), id);
  }

  public abstract String getResource();
}
