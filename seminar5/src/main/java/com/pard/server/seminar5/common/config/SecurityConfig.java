package com.pard.server.seminar5.common.config;

import com.pard.server.seminar5.member.service.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor // final 변수 자동 생성자 주입
public class SecurityConfig { // Cors 에서 만든 설정 파일로 필터링 하겠다~

    private final PrincipalOauth2UserService principalOauth2UserService;

    private final CorsConfig corsConfig;

    @Bean // Spring이 관리하는 빈(Bean) 컨테이너에 등록
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception { // 스프링 시큐리티가 reqeust 필터링할 때 사용할 규칙

        http.csrf(AbstractHttpConfigurer::disable); // 보통 프론트 분리된 구조에서 JWT 쓸 땐 끄는 게 일반적

        http.addFilter(corsConfig.corsFilter()); // 이걸로 일단 한 번 필터로 거름

        http.authorizeHttpRequests(au -> au.anyRequest().permitAll());

        http.oauth2Login(
                oauth -> oauth
                .loginPage("/loginForm") // 로긴 창 띄우고
                .defaultSuccessUrl("/home") // 로긴 성공하면 home으로 가
                .userInfoEndpoint(userInfo -> userInfo.userService(principalOauth2UserService))
        );

        return http.build();
    }
}
