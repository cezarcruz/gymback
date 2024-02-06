/* Under MIT License (C)2024 */
package br.com.gymback.application;

import br.com.gymback.application.config.context.ApplicationContextConfig;
import br.com.gymback.worker.config.WorkerContextConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
@Import({WorkerContextConfig.class, ApplicationContextConfig.class})
public class GymBackApplication {
  public static void main(final String... args) {
    SpringApplication.run(GymBackApplication.class, args);
  }
}
