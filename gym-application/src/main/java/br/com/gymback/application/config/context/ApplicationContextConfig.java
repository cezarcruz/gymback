package br.com.gymback.application.config.context;

import br.com.gymback.core.CoreConfig;
import br.com.gymback.persistence.PersistenceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Import(
    {
        PersistenceConfig.class,
        CoreConfig.class
    }
)
@Configuration
@Profile("!test")
public class ApplicationContextConfig {

}
