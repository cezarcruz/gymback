package br.com.gymback.persistence.out.mysql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.gymback.core.domain.AddressDomain;
import br.com.gymback.persistence.JPAIntegrationAbstract;
import br.com.gymback.persistence.fixture.AddressFixtures;
import br.com.gymback.persistence.out.mysql.entity.AddressEntity;
import br.com.gymback.persistence.out.mysql.repository.AddressRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AddressMysqlGatewayTest extends JPAIntegrationAbstract {


  @Autowired
  private AddressMysqlGateway addressMysqlGateway;

  @Autowired
  private AddressRepository addressRepository;

  @Test
  void shouldSaveAddress() {
    final AddressDomain address = AddressFixtures.getAddress();
    addressMysqlGateway.save(address);

    final List<AddressEntity> all = addressRepository.findAll();
    assertNotNull(all);
    assertEquals(1, all.size());
  }

}