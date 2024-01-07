package br.com.cezarcruz.gateway;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "br.com.cezarcruz.gateway.out.persistence.mysql.entity")
@EnableJpaRepositories(basePackages = "br.com.cezarcruz.gateway.out.persistence.mysql.repository")
@ComponentScan(basePackages = "br.com.cezarcruz.gateway.out.persistence.mysql")
public class PersistenceConfig {

}
