/* Under MIT License (C)2024 */
package br.com.gymback.messaging.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "br.com.gymback.messaging.out.kafka")
public class MessagingContextConfig {}
