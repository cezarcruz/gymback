/* Under MIT License (C)2024 */
package br.com.gymback.core.exceptions;

public class ContractNotFoundException extends NotFoundException {

  public ContractNotFoundException(final Long id) {
    super(id);
  }

  @Override
  public String getResource() {
    return "contract";
  }
}
