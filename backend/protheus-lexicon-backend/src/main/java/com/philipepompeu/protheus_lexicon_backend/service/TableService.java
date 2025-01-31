package com.philipepompeu.protheus_lexicon_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.philipepompeu.protheus_lexicon_backend.repository.TableEntity;
import com.philipepompeu.protheus_lexicon_backend.repository.TableRepository;

@Service
public class TableService {

    @Autowired
    private final TableRepository repository;

    public TableService(TableRepository repository) {
        this.repository = repository;
    }

    public List<TableEntity> getAllTables() {
        return repository.findAll();
    }

    public Page<TableEntity> getTables(int page, int size, String id) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        
        if (id != null && !id.isEmpty()) {
            return repository.findByIdContainingIgnoreCase(id, pageable);
        }
        return repository.findAllByOrderById(pageable);
    }
}
