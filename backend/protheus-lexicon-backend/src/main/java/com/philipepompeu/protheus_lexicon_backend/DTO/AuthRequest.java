package com.philipepompeu.protheus_lexicon_backend.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest/*(String username, String password)*/ {
    
    
    @Schema(description = "Nome de usuário", example = "admin")
    private String username;

    @Schema(description = "Senha do usuário", example = "123457")
    private String password;    
}
