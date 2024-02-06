/* Under MIT License (C)2024 */
package br.com.gymback.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "br.com.gymback.core.usecase")
public class CoreContextConfig {}
