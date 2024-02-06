package br.com.gymback.persistence.out.mysql;

import br.com.gymback.persistence.out.mysql.mapper.AddressPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.AddressRepository;
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
