package com.philipepompeu.protheus_lexicon_backend.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.philipepompeu.protheus_lexicon_backend.domain.FieldEntity;
import com.philipepompeu.protheus_lexicon_backend.repository.FieldRepository;

@SpringBootTest
public class FieldServiceTest {

    @Mock
    private FieldRepository fieldRepository;

    @InjectMocks
    private FieldService fieldService;

    @Test
    public void testGetFieldsByTableId() throws JsonMappingException, JsonProcessingException {

        FieldEntity fieldEntity = new FieldEntity();
        fieldEntity.setField("CNA_CONTRA");
        fieldEntity.setType("C");
        fieldEntity.setTitle("Nr Contrato");
        fieldEntity.setDecimal(0);
        fieldEntity.setSize(15);
        fieldEntity.setDescription("Nr Contrato");        
        
        // Simulando retorno do repository
        List<FieldEntity> mockFields = List.of(fieldEntity);
        
        when(fieldRepository.findByTable_IdOrderBySequence("CNA")).thenReturn(mockFields);

        // Chamando o serviço
        List<FieldEntity> result = fieldService.getFieldsByTableId("CNA");

        // Verificando se os dados retornados săo os esperados
        assertEquals(1, result.size());
        assertEquals("CNA_CONTRA", result.get(0).getField());
    }
}

