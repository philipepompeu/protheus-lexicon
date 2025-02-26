package com.philipepompeu.protheus_lexicon_backend.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.philipepompeu.protheus_lexicon_backend.DTO.AuthRequest;
import com.philipepompeu.protheus_lexicon_backend.DTO.AuthResponse;
import com.philipepompeu.protheus_lexicon_backend.domain.UserEntity;
import com.philipepompeu.protheus_lexicon_backend.infra.security.TokenService;
import com.philipepompeu.protheus_lexicon_backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    
    public Optional<AuthResponse> authenticate(AuthRequest request) {
        try {
            UserEntity user = userRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
            
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                String token = tokenService.generateToken(user);
                return Optional.of(new AuthResponse(user.getUsername(), token));
            }
            
            logger.debug("Password mismatch for user: {}", request.getUsername());
            return Optional.empty();
        } catch (UsernameNotFoundException e) {
            logger.debug("User not found: {}", request.getUsername());
            return Optional.empty();
        }
    }
    
    public Optional<AuthResponse> register(AuthRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            logger.debug("Username already exists: {}", request.getUsername());
            return Optional.empty();
        }
        
        UserEntity newUser = new UserEntity();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        
        userRepository.save(newUser);
        String token = tokenService.generateToken(newUser);
        
        logger.info("New user registered: {}", request.getUsername());
        return Optional.of(new AuthResponse(newUser.getUsername(), token));
    }
}
