package br.com.cezarcruz.gymback.core.domain;

import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.AddressEntity;
import lombok.Builder;

@Builder
public record Address (
    Long id,
    String zipCode,
    String street,
    String neighborhood,
    String addressNumber
) {

  public static Address fromEntity(AddressEntity address) {
    return new Address(
        address.getId(),
        address.getZipCode(),
        address.getStreet(),
        address.getNeighborhood(),
        address.getAddressNumber());
  }

  public AddressEntity toEntity() {
    final var addressEntity = new AddressEntity();

    addressEntity.setId(id());
    addressEntity.setZipCode(zipCode());
    addressEntity.setStreet(street());
    addressEntity.setNeighborhood(neighborhood());
    addressEntity.setAddressNumber(addressNumber());

    return addressEntity;
  }

}
