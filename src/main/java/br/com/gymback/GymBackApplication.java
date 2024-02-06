/* Under MIT License (C)2024 */
package br.com.gymback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
public class GymBackApplication {
  public static void main(final String... args) {
    SpringApplication.run(GymBackApplication.class, args);
  }
}
