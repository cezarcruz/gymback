/* Under MIT License (C)2024 */
package br.com.gymback.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "br.com.gymback.persistence.out.mysql.entity")
@EnableJpaRepositories(basePackages = "br.com.gymback.persistence.out.mysql.repository")
@ComponentScan(basePackages = "br.com.gymback.persistence.out.mysql")
public class PersistenceContextConfig {}
