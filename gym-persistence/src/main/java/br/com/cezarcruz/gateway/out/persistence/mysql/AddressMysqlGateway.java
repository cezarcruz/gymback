package br.com.cezarcruz.gateway.out.persistence.mysql;

import br.com.cezarcruz.gateway.out.persistence.mysql.mapper.AddressPersistenceMapper;
import br.com.cezarcruz.gateway.out.persistence.mysql.repository.AddressRepository;
import br.com.gymback.core.domain.AddressDomain;
import br.com.gymback.core.gateway.student.SaveAddressGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class AddressMysqlGateway implements SaveAddressGateway {

  private final AddressRepository addressRepository;
  private final AddressPersistenceMapper addressPersistenceMapper;

  @Override
  public AddressDomain save(final AddressDomain address) {
    final var entity = addressPersistenceMapper.fromDomain(address);
    final var saved = addressRepository.save(entity);
    return addressPersistenceMapper.fromEntity(saved);
  }
}
