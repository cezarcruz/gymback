package br.com.cezarcruz.gymback.gateway.out.gateway.student;

import br.com.cezarcruz.gymback.core.domain.Address;

public interface SaveAddressGateway {
  Address save(final Address address);
}
