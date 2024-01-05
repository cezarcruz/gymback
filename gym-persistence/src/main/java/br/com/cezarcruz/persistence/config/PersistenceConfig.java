package br.com.cezarcruz.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {
    "br.com.cezarcruz.persistence.mysql.repository",
})
@EntityScan(basePackages = {
    "br.com.cezarcruz.persistence.mysql.entity",
})
@ComponentScans({
    @ComponentScan(basePackages = "br.com.cezarcruz.persistence")
})
public class PersistenceConfig {

}
