package com.philipepompeu.protheus_lexicon_backend.infra.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.philipepompeu.protheus_lexicon_backend.service.CustomUserDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final SecurityFilter securityFilter;

    private final CustomUserDetailsService customUserDetailsService;

    @Value("${api.security.cors.allowed.origin}")
    private String allowedCorsOrigin;

    public SecurityConfig(  SecurityFilter securityFilter,
                            CustomUserDetailsService customUserDetailsService){
        this.securityFilter = securityFilter;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { 
        
        String[] swaggerPattern = { "/swagger-ui.html",
                                    "/v3/api-docs/**",
                                    "/v3/api-docs.yaml",
                                    "/swagger-ui/**",
                                    "/swagger-ui/index.html",
                                    "/swagger-ui/**"};
        http
        .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Habilita CORS
        .csrf(csrf -> csrf.disable()) // Desabilita CSRF para facilitar testes com Postman
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
        .requestMatchers(swaggerPattern).permitAll()
        .requestMatchers(HttpMethod.POST, "/auth/login","/auth/register","/auth/**","/swagger-ui/**", "/swagger-ui.html").permitAll()
        .anyRequest().authenticated()
        ).addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOriginPattern("http://*");
        configuration.setAllowedOrigins(List.of(allowedCorsOrigin,"http://localhost:8080")); // Permite o frontend Vue
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    
}
