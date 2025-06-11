package com.philipepompeu.protheus_lexicon_backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.philipepompeu.protheus_lexicon_backend.DTO.TableDto;
import com.philipepompeu.protheus_lexicon_backend.domain.TableEntity;
import com.philipepompeu.protheus_lexicon_backend.repository.TableRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TableServiceTest {

    @Mock(lenient = true)
    private TableRepository tableRepository;

    @InjectMocks
    private TableService tableService;

    /*@Test
    void deveRetornarTabelas() {
        
        List<TableDto> mockTables = List.of(
            new TableDto("CN9", "Contratos", "CN9_FILIAL+CN9_NUMERO+CN9_REVISA"),
            new TableDto("CNA", "Cabeçalho Planilhas Contratos", "CNA_FILIAL+CNA_CONTRA+CNA_REVISA+CNA_NUMERO")
        );
        
        List<TableEntity> mockEntity = List.of(
            new TableEntity("CN9", "Contratos", "CN9_FILIAL+CN9_NUMERO+CN9_REVISA"),
            new TableEntity("CNA", "Cabeçalho Planilhas Contratos", "CNA_FILIAL+CNA_CONTRA+CNA_REVISA+CNA_NUMERO")
        );
        
        Page<TableEntity> mockPage = new PageImpl<>(mockEntity);

        when(tableRepository.findAllByOrderById(any(Pageable.class)))
                            .thenReturn(mockPage);

        Page<TableDto>teste = tableService.getTables(1,10,null);
        
        if (teste != null) {
            List<TableDto> tables = teste.getContent();        
            assertEquals(2, tables.size());
            assertEquals("CN9", tables.get(0).getId());
            
        }

        assertTrue(true);//ajustar teste
    }*/
}

