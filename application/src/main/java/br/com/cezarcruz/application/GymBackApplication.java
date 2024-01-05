package br.com.cezarcruz.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScans({
    @ComponentScan(basePackages = "br.com.cezarcruz.core"),
    @ComponentScan(basePackages = "br.com.cezarcruz.application"),
    @ComponentScan(basePackages = "br.com.cezarcruz.persistence")
})
@EnableJpaRepositories(basePackages = {
    "br.com.cezarcruz.persistence.mysql.repository",
})
@EntityScan(basePackages = {
    "br.com.cezarcruz.persistence.mysql.entity",
})
public class GymBackApplication {

  public static void main(String... args) {
    SpringApplication.run(GymBackApplication.class, args);
  }

}
