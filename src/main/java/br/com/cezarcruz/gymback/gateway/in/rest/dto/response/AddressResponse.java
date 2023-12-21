package br.com.cezarcruz.gymback.gateway.in.rest.dto.response;

import br.com.cezarcruz.gymback.core.domain.Address;

public record AddressResponse (
    Long id,
    String zipCode,
    String street,
    String neighborhood,
    String addressNumber

) {

  public static AddressResponse from(Address address) {
    return new AddressResponse(address.id(),
        address.zipCode(),
        address.addressNumber(),
        address.neighborhood(),
        address.addressNumber());
  }
}
