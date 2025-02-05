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

import com.philipepompeu.protheus_lexicon_backend.entity.TableEntity;
import com.philipepompeu.protheus_lexicon_backend.service.TableService;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/tables")
@Tag(   name = "Tabelas", 
        description = "Consulta o SX2 do Protheus",
        externalDocs = @ExternalDocumentation( description="SX2 - Tabelas de Dados", url="https://tdn.totvs.com/display/public/framework/SX2+-+Tabelas+de+Dados"))
public class TableController {

    @Autowired
    private final TableService service;

    public TableController(TableService service) {
        this.service = service;
    }

   @GetMapping
   @Operation(summary = "Lista todas as tabelas do SX2 do Protheus")
    public ResponseEntity<Page<TableEntity>> getTables(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String id
    ) {
        Page<TableEntity> tables = service.getTables(page, size, id);
        return ResponseEntity.ok(tables);
    }

    @GetMapping("/{tableId}")
    @Operation(summary = "Obtêm os dados de uma única tabela do SX2")
    public ResponseEntity<TableEntity> getTableById(@PathVariable String tableId) {
        Optional<TableEntity> table = service.getTableById(tableId);
        
        if (table.isPresent()) {
            return ResponseEntity.ok(table.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
