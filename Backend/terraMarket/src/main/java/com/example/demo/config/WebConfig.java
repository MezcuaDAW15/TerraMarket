package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*") // Aplica CORS a todos los endpoints
                .allowedOrigins("http://localhost:4200") // Dominio del cliente Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("") // Permite todos los encabezados
                .allowCredentials(true); // Permite cookies/sesiones compartidas si es necesario
    }
}
