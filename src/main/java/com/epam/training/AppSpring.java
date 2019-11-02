package com.epam.training;

import com.epam.training.config.AppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppSpring  {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App app = appContext.getBean(App.class);
            app.initialize();
            app.createPlayer();
            app.play();
        }
    }
}