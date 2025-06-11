package com.philipepompeu.protheus_lexicon_backend.infra.security;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.philipepompeu.protheus_lexicon_backend.domain.UserEntity;
import com.philipepompeu.protheus_lexicon_backend.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class SecurityFilter extends OncePerRequestFilter{

    private final TokenService tokenService;

    private final UserRepository userRepository;

    public SecurityFilter(TokenService tokenService, UserRepository userRepository){
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    private String recoverToken(HttpServletRequest request){

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;

        return authHeader.replace("Bearer ", "");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token =this.recoverToken(request);

        Optional<String> validToken = tokenService.validateToken(token);       
        
        if (validToken.isPresent()) {
            String login = validToken.get();

            UserEntity user = userRepository.findByUsername(login).orElseThrow(() -> new RuntimeException("Usuario invalido"));

            List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

            var authenticatedUser = new UsernamePasswordAuthenticationToken(user, null,authorities);

            SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
            
        }

        
        
        filterChain.doFilter(request, response);
    }
    
}
