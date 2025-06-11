package com.philipepompeu.protheus_lexicon_backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philipepompeu.protheus_lexicon_backend.DTO.AuthRequest;
import com.philipepompeu.protheus_lexicon_backend.DTO.AuthResponse;
import com.philipepompeu.protheus_lexicon_backend.DTO.TokenDto;
import com.philipepompeu.protheus_lexicon_backend.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação", description = "Realiza a autenticação")
@RequiredArgsConstructor
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "Realiza a autenticação do usuário")
    @ApiResponse(responseCode = "401", description = "Usuário inválido.")
    @ApiResponse(responseCode = "200", description = "Usuário autenticado.")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados do usuário para login") AuthRequest request) {                
        
        logger.debug("Tentativa de autenticação para usuário:{}", request.getUsername());                                            
                                            
        try {

            return this.authService.authenticate(request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(401).build());         
            
        } catch (UsernameNotFoundException e) {            
            logger.error("Falha ao autenticar", e);

            return ResponseEntity.status(401).body(null);
        }
    }
    
    @PostMapping("/register")
    @Operation(summary = "Realiza a criação do usuário")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {       

        logger.debug("Tentativa de cadastro do usuário:{}", request.getUsername());   
        try {
            
            
            return authService.register(request).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());

        } catch (Exception e) {
            logger.error("Falha ao cadastrar usuário", e);
            
            return ResponseEntity.badRequest().build();
        }       
        
    }
    
    public ResponseEntity<String> validToken(@RequestBody TokenDto token){

        

        return ResponseEntity.ok().build();
    }
}
