package com.philipepompeu.protheus_lexicon_backend.controller;

import org.springframework.web.bind.annotation.*;

import com.philipepompeu.protheus_lexicon_backend.domain.TriggerEntity;
import com.philipepompeu.protheus_lexicon_backend.service.TriggerService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/fields/{fieldId}/triggers")
@Tag(   name = "Gatilhos", 
        description = "Consulta os gatilhos do SX7 do Protheus")
public class TriggerController {

    private final TriggerService service;

    public TriggerController(TriggerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TriggerEntity>> getTriggersByField(@PathVariable String fieldId) {
        List<TriggerEntity> triggers = service.getTriggersByFieldId(fieldId);
        if (triggers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(triggers);
    }
}
