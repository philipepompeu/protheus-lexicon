package com.philipepompeu.protheus_lexicon_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philipepompeu.protheus_lexicon_backend.DTO.AuthRequest;
import com.philipepompeu.protheus_lexicon_backend.DTO.AuthResponse;
import com.philipepompeu.protheus_lexicon_backend.service.CustomUserDetailsService;
import com.philipepompeu.protheus_lexicon_backend.service.JwtService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação", description = "Realiza a autenticação")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/login")
    @Operation(summary = "Realiza a autenticação do usuário")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest request) {
        
        /*authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        

        if (userDetails != null) {
            System.out.println("Usuário autenticado: " + userDetails.getUsername());
            
        }
        final String jwtToken = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwtToken));*/

        System.out.println(String.format("UserName: %s / Password: %s",
                                            request.getUsername(),
                                            request.getPassword()));

        
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String jwtToken = jwtService.generateToken(userDetails);
    
            return ResponseEntity.ok(new AuthResponse(jwtToken));
    
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Erro: Credenciais inválidas!");
        }
    }
    
}
