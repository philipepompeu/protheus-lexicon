package com.philipepompeu.protheus_lexicon_backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.philipepompeu.protheus_lexicon_backend.repository.TableEntity;
import com.philipepompeu.protheus_lexicon_backend.repository.TableRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TableServiceTest {

    @Mock
    private TableRepository tableRepository;

    @InjectMocks
    private TableService tableService;

    @Test
    void deveRetornarTabelas() {
        List<TableEntity> mockTables = List.of(
            new TableEntity("CN9", "Contratos", "CN9_FILIAL+CN9_NUMERO+CN9_REVISA"),
            new TableEntity("CNA", "Cabeçalho Planilhas Contratos", "CNA_FILIAL+CNA_CONTRA+CNA_REVISA+CNA_NUMERO")
        );

        when(tableRepository.findAll()).thenReturn(mockTables);

        List<TableEntity> tables = tableService.getAllTables();
        assertEquals(2, tables.size());
        assertEquals("CN9", tables.get(0).getId());
    }
}

