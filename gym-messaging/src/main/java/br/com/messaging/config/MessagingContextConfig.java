/* Under MIT License (C)2024 */
package br.com.messaging.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "br.com.messaging.out.kafka")
public class MessagingContextConfig {}
