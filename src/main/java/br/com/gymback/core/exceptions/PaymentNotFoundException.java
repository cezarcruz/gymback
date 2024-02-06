/* Under MIT License (C)2024 */
package br.com.gymback.core.exceptions;

public class PaymentNotFoundException extends NotFoundException {

  public PaymentNotFoundException(final Long id) {
    super(id);
  }

  @Override
  public String getResource() {
    return "payment";
  }
}
