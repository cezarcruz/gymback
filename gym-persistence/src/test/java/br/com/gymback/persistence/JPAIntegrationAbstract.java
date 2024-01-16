/* Under MIT License (C)2024 */
package br.com.gymback.persistence;

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
public abstract class JPAIntegrationAbstract {

  @Container static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.0.31");

  @DynamicPropertySource
  static void dbProperties(final DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", () -> mySQLContainer.getJdbcUrl());
    registry.add("spring.datasource.driverClassName", () -> mySQLContainer.getDriverClassName());
    registry.add("spring.datasource.username", () -> mySQLContainer.getUsername());
    registry.add("spring.datasource.password", () -> mySQLContainer.getPassword());
    registry.add("spring.flyway.enabled", () -> "true");
  }
}
