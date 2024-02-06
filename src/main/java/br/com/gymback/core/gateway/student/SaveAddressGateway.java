/* Under MIT License (C)2024 */
package br.com.gymback.core.gateway.student;

import br.com.gymback.core.domain.AddressDomain;

public interface SaveAddressGateway {
  AddressDomain save(final AddressDomain address);
}
