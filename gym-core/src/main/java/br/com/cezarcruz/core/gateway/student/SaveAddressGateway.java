package br.com.cezarcruz.core.gateway.student;

import br.com.cezarcruz.core.domain.AddressDomain;

public interface SaveAddressGateway {
  AddressDomain save(final AddressDomain address);
}
