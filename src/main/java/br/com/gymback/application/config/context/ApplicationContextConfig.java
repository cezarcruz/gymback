/* Under MIT License (C)2024 */
package br.com.gymback.application.config.context;

import br.com.gymback.core.config.CoreContextConfig;
import br.com.gymback.messaging.config.MessagingContextConfig;
import br.com.gymback.persistence.config.PersistenceContextConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Import({PersistenceContextConfig.class, CoreContextConfig.class, MessagingContextConfig.class})
@Configuration
@Profile("!test")
public class ApplicationContextConfig {}
