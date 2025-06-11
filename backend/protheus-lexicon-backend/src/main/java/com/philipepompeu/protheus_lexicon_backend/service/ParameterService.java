package com.philipepompeu.protheus_lexicon_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.philipepompeu.protheus_lexicon_backend.domain.ParameterEntity;
import com.philipepompeu.protheus_lexicon_backend.repository.ParameterRepository;

@Service
public class ParameterService {

    private final ParameterRepository repository;

    public ParameterService(ParameterRepository repository) {
        this.repository = repository;
    }

    public List<ParameterEntity> getAllParameters() {
        return repository.findAll();
    }

    public Page<ParameterEntity> getParameters(int page, int size, String name) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        
        if (name != null && !name.isEmpty()) {
            return repository.findByNameContainingIgnoreCase(name, pageable);
        }
        return repository.findAllByOrderByName(pageable);
    }

    public Optional<ParameterEntity> getParameterByName(String name) {
        return repository.findByName(name);
    }
}
