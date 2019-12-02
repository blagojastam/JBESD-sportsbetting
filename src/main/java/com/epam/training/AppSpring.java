package com.epam.training;

import com.epam.training.config.Initializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppSpring {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(AppSpring.class, args);


        Initializer init = context.getBean(Initializer.class);
        init.initPlayer();

    }
}
