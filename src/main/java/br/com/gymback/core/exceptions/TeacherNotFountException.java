package br.com.gymback.core.exceptions;

public class TeacherNotFountException extends NotFoundException {

  public TeacherNotFountException(final Long id) {
    super(id);
  }

  @Override
  public String getResource() {
    return "teacher";
  }
}
