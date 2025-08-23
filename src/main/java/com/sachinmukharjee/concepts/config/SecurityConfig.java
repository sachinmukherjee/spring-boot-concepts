package com.sachinmukharjee.concepts.config;

import com.sachinmukharjee.concepts.authentication.JwtAuthenticationProvider;
import com.sachinmukharjee.concepts.filter.JwtAuthenticationFilter;
import com.sachinmukharjee.concepts.filter.JwtRefreshFilter;
import com.sachinmukharjee.concepts.filter.JwtValidationFilter;
import com.sachinmukharjee.concepts.filter.LoggingFilter;
import com.sachinmukharjee.concepts.service.IUserDetailsService;
import com.sachinmukharjee.concepts.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

  private final JwtUtils jwtUtils;
  private final IUserDetailsService userDetailsService;

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService);
    provider.setPasswordEncoder(passwordEncoder());
    return provider;
  }

  @Bean
  public JwtAuthenticationProvider jwtAuthenticationProvider() {
    return new JwtAuthenticationProvider(jwtUtils, userDetailsService);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager() {
    return new ProviderManager(List.of(daoAuthenticationProvider(), jwtAuthenticationProvider()));
  }

  @Bean
  public SecurityFilterChain securityFilterChain(
      HttpSecurity httpSecurity, AuthenticationManager authenticationManager, JwtUtils jwtUtils)
      throws Exception {

    // Authentication filter responsible for login
    JwtAuthenticationFilter jwtAuthFilter =
        new JwtAuthenticationFilter(authenticationManager, jwtUtils);

    // Validation filter for checking JWT in every request
    JwtValidationFilter jwtValidationFilter = new JwtValidationFilter(authenticationManager);

    // Refresh filter for checking Jwt in every request
    JwtRefreshFilter jwtRefreshFilter = new JwtRefreshFilter(jwtUtils, authenticationManager);

    // Logging Filter
    LoggingFilter loggingFilter = new LoggingFilter();

    httpSecurity
        .authorizeHttpRequests(
            auth ->
                auth.requestMatchers("/v1/user/register","/error","/actuator/*").permitAll().anyRequest().authenticated())

        .sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .csrf(csrf -> csrf.disable())
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        .addFilterAfter(jwtValidationFilter, JwtAuthenticationFilter.class)
        .addFilterAfter(jwtRefreshFilter, JwtValidationFilter.class)
        .addFilterAfter(loggingFilter, FilterSecurityInterceptor.class);

    return httpSecurity.build();
  }
}
