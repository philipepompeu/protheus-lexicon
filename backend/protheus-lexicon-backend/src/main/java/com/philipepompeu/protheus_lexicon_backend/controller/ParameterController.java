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

import com.philipepompeu.protheus_lexicon_backend.domain.ParameterEntity;
import com.philipepompeu.protheus_lexicon_backend.service.ParameterService;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/parameters")
@Tag(   name = "Parâmetros", 
        description = "Consulta o SX6 do Protheus",
        externalDocs = @ExternalDocumentation( description="SX6 - Parâmetros do Sistema", url="https://tdn.totvs.com/pages/releaseview.action?pageId=22479590"))
public class ParameterController {

    private final ParameterService service;

    public ParameterController(ParameterService service) {
        this.service = service;
    }

   @GetMapping
   @Operation(summary = "Lista todos os parâmetros do Protheus")
    public ResponseEntity<Page<ParameterEntity>> getTables(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String name
    ) {

        
        Page<ParameterEntity> params = service.getParameters(page, size, name);
        
        return ResponseEntity.ok(params);
    }

    @GetMapping("/{name}")
    @Operation(summary = "Obtêm os dados de um único parâmetro do SX6")
    public ResponseEntity<ParameterEntity> getTableById(@PathVariable String name) {
        Optional<ParameterEntity> table = service.getParameterByName(name);
        
        if (table.isPresent()) {
            return ResponseEntity.ok(table.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
