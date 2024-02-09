/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql.mapper;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class AddressPersistenceMapperTest {

  private final AddressPersistenceMapper addressPersistence = new AddressPersistenceMapperImpl();

  @Test
  void shouldDoDummyTest() {
    final var addressDomain = addressPersistence.fromEntity(null);
    assertNull(addressDomain);
  }
}
