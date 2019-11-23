package com.epam.training.config;

import com.epam.training.App;
import com.epam.training.service.SportsBettingService;
import com.epam.training.service.SportsBettingServiceImpl;
import com.epam.training.view.View;
import com.epam.training.view.ViewImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Locale;
import java.util.ResourceBundle;


@Configuration
@Import(JpaConfig.class)
public class AppConfig {

    @Bean
    public ResourceBundle getMessagesBundle() {
        String baseName = "MessagesBundle";

        ResourceBundle toReturn = ResourceBundle.getBundle(baseName, Locale.getDefault());

        if (toReturn != null) {
            return toReturn;
        } else {
            return ResourceBundle.getBundle(baseName, Locale.US);
        }
    }

    @Bean
    public SportsBettingService sportsBettingService(){
        return new SportsBettingServiceImpl();
    }

    @Bean
    public View view(){
        return new ViewImpl();
    }

    @Bean
    public App app() {
        return new App(sportsBettingService(), view());
    }


}
