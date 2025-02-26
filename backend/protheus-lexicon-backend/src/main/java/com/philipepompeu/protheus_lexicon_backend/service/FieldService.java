package com.philipepompeu.protheus_lexicon_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.philipepompeu.protheus_lexicon_backend.domain.FieldEntity;
import com.philipepompeu.protheus_lexicon_backend.repository.FieldRepository;

@Service
public class FieldService {

    private final FieldRepository fieldRepository;

    public FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public List<FieldEntity> getFieldsByTableId(String tableId) {
        return fieldRepository.findByTable_IdOrderBySequence(tableId);
    }

    public Optional<FieldEntity> getFieldByName(String fieldName) {
        return fieldRepository.findByField(fieldName);
    }
}
