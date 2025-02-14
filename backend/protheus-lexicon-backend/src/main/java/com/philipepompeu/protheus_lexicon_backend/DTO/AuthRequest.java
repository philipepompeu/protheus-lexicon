package com.philipepompeu.protheus_lexicon_backend.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    @Schema(description = "Nome de usuário", example = "admin")
    private String username;

    @Schema(description = "Senha do usuário", example = "123456")
    private String password;    
}
