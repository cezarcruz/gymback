/* Under MIT License (C)2024 */
package br.com.gymback.core.exceptions;

public class ClassRoomNotFountException extends NotFoundException {

  public ClassRoomNotFountException(final Long id) {
    super(id);
  }

  @Override
  public String getResource() {
    return "classroom";
  }
}
