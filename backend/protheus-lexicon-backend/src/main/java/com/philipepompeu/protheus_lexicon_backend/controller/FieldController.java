package com.philipepompeu.protheus_lexicon_backend.controller;

import org.springframework.web.bind.annotation.*;

import com.philipepompeu.protheus_lexicon_backend.repository.FieldEntity;
import com.philipepompeu.protheus_lexicon_backend.service.FieldService;

import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/tables/{tableId}/fields")
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
}
