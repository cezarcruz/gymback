package br.com.cezarcruz.gymback.application;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
class GymBackApplicationIntegrationTest {

	@Container
	private static final MySQLContainer<?> MY_SQL_CONTAINER = new MySQLContainer<>("mysql:8.0.31");

	@Test
	void contextLoads() {
	}

}
