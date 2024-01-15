package br.com.gymback.persistence.out.mysql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.gymback.core.domain.AddressDomain;
import br.com.gymback.persistence.TestPersistenceConfig;
import br.com.gymback.persistence.fixture.AddressFixtures;
import br.com.gymback.persistence.out.mysql.entity.AddressEntity;
import br.com.gymback.persistence.out.mysql.repository.AddressRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ContextConfiguration(classes = TestPersistenceConfig.class)
class AddressMysqlGatewayTest {

  @Container
  static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.0.31");

  @Autowired
  private AddressMysqlGateway addressMysqlGateway;

  @Autowired
  private AddressRepository addressRepository;

  @DynamicPropertySource
  static void dbProperties(final DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", () -> mySQLContainer.getJdbcUrl());
    registry.add("spring.datasource.driverClassName", () -> mySQLContainer.getDriverClassName());
    registry.add("spring.datasource.username", () -> mySQLContainer.getUsername());
    registry.add("spring.datasource.password", () -> mySQLContainer.getPassword());
    registry.add("spring.flyway.enabled", () -> "true");
  }

  @Test
  void shouldSaveAddress() {
    final AddressDomain address = AddressFixtures.getAddress();
    addressMysqlGateway.save(address);

    final List<AddressEntity> all = addressRepository.findAll();
    assertNotNull(all);
    assertEquals(1, all.size());
  }

}