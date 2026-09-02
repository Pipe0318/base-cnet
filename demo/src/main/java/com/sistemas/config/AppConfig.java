package com.sistemas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sistemas")
public class AppConfig {
    @Bean
    public String appName(){
        return "Sistema de gestion de dispositivos IoT";
    }
}
