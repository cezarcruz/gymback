package br.com.gymback.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "br.com.gymback.core.usecase")
public class CoreConfig {

}