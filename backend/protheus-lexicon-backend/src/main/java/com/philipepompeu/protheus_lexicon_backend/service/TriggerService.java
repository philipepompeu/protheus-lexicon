package com.philipepompeu.protheus_lexicon_backend.service;


import java.util.List;
import org.springframework.stereotype.Service;

import com.philipepompeu.protheus_lexicon_backend.domain.TriggerEntity;
import com.philipepompeu.protheus_lexicon_backend.repository.TriggerRepository;

@Service
public class TriggerService {

    private final TriggerRepository repository;

    public TriggerService(TriggerRepository repository) {
        this.repository = repository;
    }

    public List<TriggerEntity> getTriggersByFieldId(String fieldId) {
        return repository.findByField_FieldOrderBySequence(fieldId);
    }
}
