package br.com.gymback.application.rest.mapper;

import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.gymback.application.rest.mapper.AddressMapper;
import br.com.gymback.application.rest.mapper.AddressMapperImpl;
import org.junit.jupiter.api.Test;

class AddressMapperTest {

  private AddressMapper addressMapper = new AddressMapperImpl();

  @Test
  void shouldDoDummyTest() {
    final var addressResponse = addressMapper.fromDomain(null);
    assertNull(addressResponse);
  }

}