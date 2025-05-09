package com.pard.server.seminar5.common.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration // 나 설정파일이야. spring이 이 설정파일 먼저 보고 controller 실행시킴
public class CorsConfig { // 클라이언트가 spring한테 요청 하기 전에 이거 확인하고 양식 맞춰 요청하라는 애
    @Bean // 이건 뭔지 다시 찾아보기
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true); // 쿠키

        config.addAllowedOrigin("*"); // *은 모든 것을 뜻함. 따라서 어떤 ??든 다 받겠다

        config.addAllowedHeader("*"); // 어떤 헤더든 다 받겠다

        config.addAllowedMethod("*"); // 어떤 get post 다 받겠다

        source.registerCorsConfiguration("/*", config);

        return new CorsFilter(source);
    }
}
