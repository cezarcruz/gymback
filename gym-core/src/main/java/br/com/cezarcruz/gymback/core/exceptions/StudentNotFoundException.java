package br.com.cezarcruz.gymback.core.exceptions;

public class StudentNotFoundException extends NotFoundException {

  public StudentNotFoundException(final String id) {
    super(id);
  }

  @Override
  public String getResource() {
    return "student";
  }
}
