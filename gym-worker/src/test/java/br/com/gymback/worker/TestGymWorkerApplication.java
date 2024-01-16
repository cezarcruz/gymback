package br.com.gymback.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestGymWorkerApplication {
  @Bean
  @ServiceConnection
  KafkaContainer kafkaContainer() {
    return new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));
  }

  @Bean
  @ServiceConnection
  MySQLContainer<?> mySQLContainer() {
    return new MySQLContainer<>(DockerImageName.parse("mysql:8.0.31"));
  }

  public static void main(String[] args) {
    SpringApplication.from(GymWorkerApplication::main)
        .with(TestGymWorkerApplication.class)
        .run(args);
  }
}