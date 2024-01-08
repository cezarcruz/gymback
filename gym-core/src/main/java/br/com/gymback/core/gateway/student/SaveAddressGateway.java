package br.com.gymback.core.gateway.student;

import br.com.gymback.core.domain.AddressDomain;

public interface SaveAddressGateway {
  AddressDomain save(final AddressDomain address);
}
