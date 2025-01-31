package com.philipepompeu.protheus_lexicon_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.philipepompeu.protheus_lexicon_backend.repository.TableEntity;
import com.philipepompeu.protheus_lexicon_backend.service.TableService;

@RestController
@RequestMapping("/tables")
public class TableController {

    @Autowired
    private final TableService service;

    public TableController(TableService service) {
        this.service = service;
    }

   @GetMapping
    public ResponseEntity<Page<TableEntity>> getTables(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String id
    ) {
        Page<TableEntity> tables = service.getTables(page, size, id);
        return ResponseEntity.ok(tables);
    }
}
