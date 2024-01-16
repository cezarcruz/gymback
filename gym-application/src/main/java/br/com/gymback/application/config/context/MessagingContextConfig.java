/* Under MIT License (C)2024 */
package br.com.gymback.application.config.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "br.com.messaging.out.kafka")
public class MessagingContextConfig {}
