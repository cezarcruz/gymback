package br.com.cezarcruz.gymback.application;

import br.com.cezarcruz.gateway.PersistenceConfig;
import br.com.cezarcruz.gymback.core.CoreConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({PersistenceConfig.class, CoreConfig.class})
@SpringBootApplication
public class GymBackApplication {

  public static void main(String... args) {
    SpringApplication.run(GymBackApplication.class, args);
  }

}
