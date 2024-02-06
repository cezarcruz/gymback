/* Under MIT License (C)2024 */
package br.com.gymback.worker.config;

import br.com.gymback.core.config.CoreContextConfig;
import br.com.gymback.persistence.config.PersistenceContextConfig;
import br.com.gymback.messaging.config.MessagingContextConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CoreContextConfig.class, PersistenceContextConfig.class, MessagingContextConfig.class})
public class WorkerContextConfig {}
