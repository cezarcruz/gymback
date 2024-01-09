package br.com.gymback.application.config.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Import(
    {
        PersistenceContextConfig.class,
        CoreContextConfig.class
    }
)
@Configuration
@Profile("!test")
public class ApplicationContextConfig {

}
