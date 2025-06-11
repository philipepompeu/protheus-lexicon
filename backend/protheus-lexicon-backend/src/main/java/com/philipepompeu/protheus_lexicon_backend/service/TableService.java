package com.philipepompeu.protheus_lexicon_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.philipepompeu.protheus_lexicon_backend.DTO.TableDto;
import com.philipepompeu.protheus_lexicon_backend.DTO.TableMapper;
import com.philipepompeu.protheus_lexicon_backend.repository.TableRepository;

@Service
public class TableService {

    private final TableRepository repository;
    
    private final TableMapper mapper = new TableMapper();

    public TableService(TableRepository repository) {
        this.repository = repository;        
    }

    public List<TableDto> getAllTables() {
        return  repository.findAll().stream()      
                .map(mapper::entityToDto)
                .toList();
    }

    public Page<TableDto> getTables(int page, int size, String id) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        
        if (id != null && !id.isEmpty()) {
            return repository.findByIdContainingIgnoreCase(id, pageable).map(mapper::entityToDto);
        }
        return repository.findAllByOrderById(pageable).map(mapper::entityToDto);
    }

    public Optional<TableDto> getTableById(String tableId) {
        return repository.findById(tableId).map(mapper::entityToDto);
    }
}
