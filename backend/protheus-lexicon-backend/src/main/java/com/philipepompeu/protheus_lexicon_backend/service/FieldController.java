package com.philipepompeu.protheus_lexicon_backend.service;

import org.springframework.web.bind.annotation.*;

import com.philipepompeu.protheus_lexicon_backend.repository.FieldEntity;
import com.philipepompeu.protheus_lexicon_backend.repository.FieldRepository;

import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/tables/{tableId}/fields")
public class FieldController {

    private final FieldRepository fieldRepository;

    public FieldController(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    @GetMapping
    public ResponseEntity<List<FieldEntity>> getFieldsByTable(@PathVariable String tableId) {
        List<FieldEntity> fields = fieldRepository.findByTable_IdOrderBySequence(tableId);
        if (fields.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fields);
    }
}
