package com.philipepompeu.protheus_lexicon_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philipepompeu.protheus_lexicon_backend.entity.FieldEntity;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<FieldEntity, String> {
    List<FieldEntity> findByTable_IdOrderBySequence(String tableId);
}
