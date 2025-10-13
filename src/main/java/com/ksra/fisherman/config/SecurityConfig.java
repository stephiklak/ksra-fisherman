package com.ksra.fisherman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //Disable CSRF for APIs
                .csrf(csrf -> csrf.disable())

                //Authorize requests
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/users").permitAll() // allow registration
                        .anyRequest().authenticated()
                )

                //Enable HTTP Basic auth (new style)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
