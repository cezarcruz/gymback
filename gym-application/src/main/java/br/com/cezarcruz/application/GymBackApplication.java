package br.com.cezarcruz.application;

import br.com.cezarcruz.persistence.config.PersistenceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScans({
    @ComponentScan(basePackages = "br.com.cezarcruz.core"),
    @ComponentScan(basePackages = "br.com.cezarcruz.application"),
})
@Import(PersistenceConfig.class)
public class GymBackApplication {

  public static void main(String... args) {
    SpringApplication.run(GymBackApplication.class, args);
  }

}
