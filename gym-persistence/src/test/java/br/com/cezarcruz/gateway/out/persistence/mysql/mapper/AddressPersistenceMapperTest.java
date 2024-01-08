package br.com.cezarcruz.gateway.out.persistence.mysql.mapper;

import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.gymback.persistence.out.mysql.mapper.AddressPersistenceMapper;
import br.com.gymback.persistence.out.mysql.mapper.AddressPersistenceMapperImpl;
import org.junit.jupiter.api.Test;

class AddressPersistenceMapperTest {

  private AddressPersistenceMapper addressPersistence = new AddressPersistenceMapperImpl();

  @Test
  void shouldDoDummyTest() {
    final var addressDomain = addressPersistence.fromEntity(null);
    assertNull(addressDomain);
  }

}