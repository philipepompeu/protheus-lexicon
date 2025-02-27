package com.philipepompeu.protheus_lexicon_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
public class TableDto {
    
    private String id ;
    private String description ;
    private String primaryKey;
}
