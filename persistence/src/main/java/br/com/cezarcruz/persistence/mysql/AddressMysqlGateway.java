package br.com.cezarcruz.persistence.mysql;

import br.com.cezarcruz.core.domain.AddressDomain;
import br.com.cezarcruz.core.gateway.student.SaveAddressGateway;
import br.com.cezarcruz.persistence.mysql.mapper.AddressPersistenceMapper;
import br.com.cezarcruz.persistence.mysql.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class AddressMysqlGateway implements SaveAddressGateway {

  private final AddressRepository addressRepository;
  private final AddressPersistenceMapper addressPersistenceMapper;

  @Override
  public AddressDomain save(final AddressDomain address) {
    final var entity = addressPersistenceMapper.from(address);
    final var saved = addressRepository.save(entity);
    return addressPersistenceMapper.from(saved);
  }
}
