package com.philipepompeu.protheus_lexicon_backend.service;


import java.util.List;
import org.springframework.stereotype.Service;

import com.philipepompeu.protheus_lexicon_backend.domain.IndexEntity;
import com.philipepompeu.protheus_lexicon_backend.repository.IndexRepository;

@Service
public class IndexService {

    private final IndexRepository repository;

    public IndexService(IndexRepository repository) {
        this.repository = repository;
    }

    public List<IndexEntity> getIndexesByTableId(String tableId) {
        return repository.findByTable_IdOrderBySequence(tableId);
    }
}
