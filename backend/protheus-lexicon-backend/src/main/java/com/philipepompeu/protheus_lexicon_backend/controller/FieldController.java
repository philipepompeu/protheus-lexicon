package com.philipepompeu.protheus_lexicon_backend.controller;

import org.springframework.web.bind.annotation.*;

import com.philipepompeu.protheus_lexicon_backend.domain.FieldEntity;
import com.philipepompeu.protheus_lexicon_backend.service.FieldService;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/tables/{tableId}/fields")
@Tag(   name = "Campos", 
        description = "Consulta o SX3 do Protheus",
        externalDocs = @ExternalDocumentation( description="SX3 - Campos das tabelas", url="https://tdn.totvs.com/display/public/framework/SX3+-+Campos+das+tabelas"))
public class FieldController {

    private final FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @GetMapping
    public ResponseEntity<List<FieldEntity>> getFieldsByTable(@PathVariable String tableId) {
        List<FieldEntity> fields = fieldService.getFieldsByTableId(tableId);
        if (fields.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fields);
    }

    @GetMapping("/{fieldName}")
    public ResponseEntity<FieldEntity> getFieldByName(@PathVariable String tableId, @PathVariable String fieldName) {
        return fieldService.getFieldByName(fieldName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
