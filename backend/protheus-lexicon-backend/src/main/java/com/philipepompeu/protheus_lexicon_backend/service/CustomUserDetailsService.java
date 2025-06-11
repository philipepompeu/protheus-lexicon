package com.philipepompeu.protheus_lexicon_backend.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.philipepompeu.protheus_lexicon_backend.domain.UserEntity;
import com.philipepompeu.protheus_lexicon_backend.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private final UserRepository userRepository; 

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário inválido."));       

        logger.debug(String.format("Tentativa de login do usuário: %s", user.getUsername()));
        
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            new ArrayList<>()
        );

        return userDetails;      

    }
}

