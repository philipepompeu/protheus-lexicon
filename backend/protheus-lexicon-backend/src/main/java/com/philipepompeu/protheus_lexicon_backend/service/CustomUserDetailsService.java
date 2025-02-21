package com.philipepompeu.protheus_lexicon_backend.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.philipepompeu.protheus_lexicon_backend.entity.UserEntity;
import com.philipepompeu.protheus_lexicon_backend.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário inválido."));
        
        System.out.println(String.format("Tentativa de login do usuário: %s", user.getUsername())); 
        
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            new ArrayList<>()
        );

        return userDetails;      

    }
}

