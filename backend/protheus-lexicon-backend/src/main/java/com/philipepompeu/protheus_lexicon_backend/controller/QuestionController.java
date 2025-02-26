package com.philipepompeu.protheus_lexicon_backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.philipepompeu.protheus_lexicon_backend.domain.QuestionEntity;
import com.philipepompeu.protheus_lexicon_backend.domain.TableEntity;
import com.philipepompeu.protheus_lexicon_backend.service.QuestionService;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/questions")
@Tag(   name = "Grupo de Perguntas", 
        description = "Consulta o SX1 do Protheus")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

   @GetMapping
   @Operation(summary = "Lista todos os perguntes do Protheus")
    public ResponseEntity<Page<QuestionEntity>> getQuestions(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String name
    ) {

        
        Page<QuestionEntity> params = service.getQuestions(page, size, name);
        
        return ResponseEntity.ok(params);
    }

    @GetMapping("/{groupName}")
    @Operation(summary = "Obtêm os dados de um único grupo de perguntas do SX1")
    public ResponseEntity<QuestionEntity> getTableById(@PathVariable String groupName) {
        Optional<QuestionEntity> table = service.getQuestionByName(groupName);
        
        if (table.isPresent()) {
            return ResponseEntity.ok(table.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    
}
