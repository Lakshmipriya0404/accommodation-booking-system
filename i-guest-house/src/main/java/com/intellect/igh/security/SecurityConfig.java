package com.intellect.igh.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    private final jwtFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req->
                        req.requestMatchers(
                                        "/auth/**",
                                        "/v2/api-docs",
                                        "/v3/api-docs",
                                        "/v3/api-docs/**",
                                        "/swagger-resources",
                                        "/swagger-resources/**",
                                        "/configuration/ui",
                                        "/configuration/secrity",
                                        "/swagger-ui/**",
                                        "/webjars/**",
                                        "/swagger-ui.html"
                        ).permitAll()
                        // Role-based access control
                        .requestMatchers(HttpMethod.POST, "/rooms/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/rooms/**").hasAnyRole("MANAGER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/booking").hasAnyRole("HR", "EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/booking").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/booking/update-room-number").hasRole("MANAGER")  // Only Manager can update the room number
                        .requestMatchers("/booking/**").hasAnyRole("HR", "MANAGER", "ADMIN", "EMPLOYEE")
                        .requestMatchers("/food/preference").hasAnyRole("HR", "MANAGER", "ADMIN", "EMPLOYEE")
                        .requestMatchers("/dailyMeal").hasAnyRole("HR", "MANAGER", "ADMIN", "EMPLOYEE")
                        .anyRequest().authenticated()
                    )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
