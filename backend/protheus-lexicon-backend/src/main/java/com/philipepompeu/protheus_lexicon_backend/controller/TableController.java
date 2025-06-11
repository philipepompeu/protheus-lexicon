package com.philipepompeu.protheus_lexicon_backend.controller;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.philipepompeu.protheus_lexicon_backend.DTO.DownloadFile;
import com.philipepompeu.protheus_lexicon_backend.DTO.TableDto;
import com.philipepompeu.protheus_lexicon_backend.service.TableReportService;
import com.philipepompeu.protheus_lexicon_backend.service.TableService;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/tables")
@OpenAPIDefinition(info = @Info(
    title = "API Protheus Lexicon", version = "1.0"
))
@Tag(   name = "Tabelas", 
        description = "Consulta o SX2 do Protheus",
        externalDocs = @ExternalDocumentation( description="SX2 - Tabelas de Dados", url="https://tdn.totvs.com/display/public/framework/SX2+-+Tabelas+de+Dados"))
public class TableController {

    private final TableService service;    
    private final TableReportService tableReportService;

    public TableController(TableService service, TableReportService tableReportService) {
        this.service = service;
        this.tableReportService = tableReportService;
    }

   @GetMapping
   @Operation(summary = "Lista todas as tabelas do SX2 do Protheus")
    public ResponseEntity<Page<TableDto>> getTables(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String id
    ) {
        Page<TableDto> tables = service.getTables(page, size, id);
        return ResponseEntity.ok(tables);
    }

    @GetMapping("/{tableId}")
    @Operation(summary = "Obtêm os dados de uma única tabela do SX2")
    public ResponseEntity<TableDto> getTableById(@PathVariable String tableId) {
        Optional<TableDto> table = service.getTableById(tableId);
        
        if (table.isPresent()) {
            return ResponseEntity.ok(table.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{tableId}/pdf")
    @Operation(summary = "Obtêm os dados de uma única tabela do SX2")
    public ResponseEntity<DownloadFile> tableToPdf(@PathVariable String tableId) throws NameNotFoundException {
        
        TableDto table = service.getTableById(tableId).orElseThrow(()-> new NameNotFoundException());
        
        return ResponseEntity.ok(this.tableReportService.printReport(table));
    }
}
