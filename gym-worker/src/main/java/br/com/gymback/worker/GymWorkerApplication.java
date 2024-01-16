/* Under MIT License (C)2024 */
package br.com.gymback.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class GymWorkerApplication {
  public static void main(final String... args) {
    SpringApplication.run(GymWorkerApplication.class, args);
  }

}
