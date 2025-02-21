package com.philipepompeu.protheus_lexicon_backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philipepompeu.protheus_lexicon_backend.DTO.AuthRequest;
import com.philipepompeu.protheus_lexicon_backend.DTO.AuthResponse;
import com.philipepompeu.protheus_lexicon_backend.entity.UserEntity;
import com.philipepompeu.protheus_lexicon_backend.infra.security.TokenService;
import com.philipepompeu.protheus_lexicon_backend.repository.UserRepository;
import com.philipepompeu.protheus_lexicon_backend.service.CustomUserDetailsService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação", description = "Realiza a autenticação")
@RequiredArgsConstructor
public class AuthController {
    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;    

    @PostMapping("/login")
    @Operation(summary = "Realiza a autenticação do usuário")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {                
        

        System.out.println(String.format("UserName: %s / Password: %s",
                                            request.getUsername(),
                                            request.getPassword()));                                            
                                            
        try {
            UserEntity user = this.userRepository.findByUsername(request.getUsername())
                                                    .orElseThrow(()->new UsernameNotFoundException("Erro: Credenciais inválidas!"));

            

            System.out.println(String.format("user.getPassword() = %s / request.getPassword() = %s",user.getPassword(),this.passwordEncoder.encode(request.getPassword()) ));        
            
            
            
            if (this.passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                String token = tokenService.generateToken(user);                
                return ResponseEntity.ok(new AuthResponse(user.getUsername(), token));
            }else{
                System.out.println("passwordEncoder-> not match");
            }    

            return ResponseEntity.badRequest().build();
        } catch (UsernameNotFoundException e) {
            
            System.out.println("UserNotFound>"+e.getMessage());
            return ResponseEntity.status(401).body(null);
        }
    }
    
    @PostMapping("/register")
    @Operation(summary = "Realiza a criação do usuário")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {       

        Optional<UserEntity> foundUser = this.userRepository.findByUsername(request.getUsername());

        if (foundUser.isEmpty()) {
            
            UserEntity newUser = new UserEntity();
            newUser.setUsername(request.getUsername());      
            
            newUser.setPassword(this.passwordEncoder.encode(request.getPassword()));        
    
            this.userRepository.save(newUser);
            String token = tokenService.generateToken(newUser);                
            
            return ResponseEntity.ok(new AuthResponse(newUser.getUsername(), token));                                           
        }

        return ResponseEntity.badRequest().build();
        
    }
    
}
