package com.philipepompeu.protheus_lexicon_backend.DTO;


import com.philipepompeu.protheus_lexicon_backend.domain.TableEntity;

public class TableMapper {
    
    public TableMapper(){

    }
    
    
    public TableDto entityToDto(TableEntity table){
        return new TableDto(table.getId(),
                            table.getDescription(),
                            table.getPrimaryKey());
    }

    public TableEntity dtoToEntity(TableDto dto){
        return new TableEntity(dto.getId(), dto.getDescription(), dto.getPrimaryKey());
    }
}
