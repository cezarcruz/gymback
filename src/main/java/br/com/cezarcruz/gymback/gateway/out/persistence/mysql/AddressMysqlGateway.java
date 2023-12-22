package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.Address;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.SaveAddressGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class AddressMysqlGateway implements SaveAddressGateway {

  private final AddressRepository addressRepository;

  @Override
  public Address save(final Address address) {
    final var entity = address.toEntity();
    final var saved = addressRepository.save(entity);
    return Address.fromEntity(saved);
  }
}
