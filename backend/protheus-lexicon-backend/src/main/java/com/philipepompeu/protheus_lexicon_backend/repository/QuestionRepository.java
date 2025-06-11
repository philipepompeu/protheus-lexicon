package com.philipepompeu.protheus_lexicon_backend.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.philipepompeu.protheus_lexicon_backend.domain.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, String>{

    
    Optional<QuestionEntity> findByName(String name);    
    Page<QuestionEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
    
    @Query("SELECT distinct q FROM QuestionEntity q WHERE q.name <> '' ")
    Page<QuestionEntity> findAllGroups(Pageable pageable);
    
}
