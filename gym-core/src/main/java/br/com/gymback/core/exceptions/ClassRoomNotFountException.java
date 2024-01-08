package br.com.gymback.core.exceptions;

public class ClassRoomNotFountException extends NotFoundException {

  public ClassRoomNotFountException(final String id) {
    super(id);
  }

  @Override
  public String getResource() {
    return "classroom";
  }
}
