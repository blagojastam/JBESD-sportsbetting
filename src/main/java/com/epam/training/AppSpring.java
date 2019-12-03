package com.epam.training;

import com.epam.training.config.Initializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.epam.training"}, exclude = SecurityAutoConfiguration.class)
public class AppSpring {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(AppSpring.class, args);

        Initializer init = context.getBean(Initializer.class);
        init.setUp();
    }
}
