package com.philipepompeu.protheus_lexicon_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.philipepompeu.protheus_lexicon_backend.domain.QuestionEntity;
import com.philipepompeu.protheus_lexicon_backend.repository.QuestionRepository;

@Service
public class QuestionService {

    private final QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public List<QuestionEntity> getAllQuestions() {
        return repository.findAll();
    }

    public Page<QuestionEntity> getQuestions(int page, int size, String name) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        
        if (name != null && !name.isEmpty()) {
            return repository.findByNameContainingIgnoreCase(name, pageable);
        }
        return repository.findAllGroups(pageable);
    }

    public Optional<QuestionEntity> getQuestionByName(String name) {
        return repository.findByName(name);
    }

    
}
