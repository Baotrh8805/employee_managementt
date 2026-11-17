package com.example.employee_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http
//                Off to use POST
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/public/**", "/api/auth/**").permitAll()
//                        Tạm thời set permitAll()
                        .requestMatchers("/api/v1/employees/**").permitAll()
                        .requestMatchers("/employees/**").permitAll()
                        .anyRequest().authenticated());
        return http.build();
    }
}
