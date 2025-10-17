package com.ksra.fisherman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(1) // ensures this runs before the default AppConfig SecurityFilterChain
public class CognitoSecurityConfig {

    @Bean
    public SecurityFilterChain cognitoSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for APIs
                .csrf(csrf -> csrf.disable())

                // Define which routes are public and which need Cognito login
                .securityMatcher("/api/**", "/user/**") // apply this only to these paths
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**", "/error", "/test-db").permitAll()
                        .anyRequest().authenticated()
                )

                // Enable Cognito OAuth2 login (Hosted UI)
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/api/users1", true)
                )

                // Logout handler
                .logout(logout -> logout
                        .logoutSuccessUrl("/public/logout-success")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .permitAll()
                );

        return http.build();
    }
}
