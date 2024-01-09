package br.com.gymback.core.exceptions;

public class ModalityNotFountException extends NotFoundException {

  public ModalityNotFountException(final String id) {
    super(id);
  }

  @Override
  public String getResource() {
    return "modality";
  }
}
