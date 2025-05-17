package com.pard.server.seminar6.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        어떤 경로든
        registry.addMapping("/**")
                // localhost:3000에서 오는 요청을 허용
                .allowedOrigins("http://localhost:3000")
                // GET, POST, PUT, DELETE 요청을 허용
                .allowedMethods("GET","POST","PATCH","DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
