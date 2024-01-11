package br.com.gymback.core.exceptions;

public class StudentNotFoundException extends NotFoundException {

  public StudentNotFoundException(final Long id) {
    super(id);
  }

  @Override
  public String getResource() {
    return "student";
  }
}
