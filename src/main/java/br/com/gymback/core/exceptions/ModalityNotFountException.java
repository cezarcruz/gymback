/* Under MIT License (C)2024 */
package br.com.gymback.core.exceptions;

public class ModalityNotFountException extends NotFoundException {

  public ModalityNotFountException(final Long id) {
    super(id);
  }

  @Override
  public String getResource() {
    return "modality";
  }
}
