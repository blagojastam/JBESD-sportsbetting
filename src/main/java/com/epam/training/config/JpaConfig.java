package com.epam.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.epam.training.repository"})
public class JpaConfig {

    @Bean
    Initializer getInitializer() {
        return new Initializer();
    }
}
