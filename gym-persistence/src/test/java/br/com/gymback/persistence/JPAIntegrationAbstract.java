/* Under MIT License (C)2024 */
package br.com.gymback.persistence;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ContextConfiguration(classes = TestPersistenceConfig.class)
public abstract class JPAIntegrationAbstract {

  @ServiceConnection @Container
  static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.0.31");
}
