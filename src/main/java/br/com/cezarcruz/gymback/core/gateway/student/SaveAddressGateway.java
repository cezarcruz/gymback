package br.com.cezarcruz.gymback.core.gateway.student;

import br.com.cezarcruz.gymback.core.domain.AddressDomain;

public interface SaveAddressGateway {
  AddressDomain save(final AddressDomain address);
}
