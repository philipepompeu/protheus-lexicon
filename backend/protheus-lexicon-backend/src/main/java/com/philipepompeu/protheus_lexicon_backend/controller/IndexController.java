package com.philipepompeu.protheus_lexicon_backend.controller;

import org.springframework.web.bind.annotation.*;

import com.philipepompeu.protheus_lexicon_backend.domain.IndexEntity;
import com.philipepompeu.protheus_lexicon_backend.service.IndexService;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/tables/{tableId}/indexes")
@Tag(   name = "Índices", 
        description = "Consulta os índices do SIX do Protheus", 
        externalDocs = @ExternalDocumentation( description="SIX - Índice das Tabelas", url="https://tdn.totvs.com/pages/releaseview.action?pageId=22479575"))
public class IndexController {

    private final IndexService service;

    public IndexController(IndexService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<IndexEntity>> getFieldsByTable(@PathVariable String tableId) {
        List<IndexEntity> indexes = service.getIndexesByTableId(tableId);
        if (indexes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(indexes);
    }
}
