package com.propertymangement.app.corsconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig {

	@Bean
    public WebMvcConfigurer getCorsConfigurer(){
        return new WebMvcConfigurer() {
            
        	@Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*", "GET")
                .allowedHeaders("*");
            }
        };
    }
}
