package com.philipepompeu.protheus_lexicon_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philipepompeu.protheus_lexicon_backend.domain.FieldEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface FieldRepository extends JpaRepository<FieldEntity, String> {
    List<FieldEntity> findByTable_IdOrderBySequence(String tableId);

    Optional<FieldEntity> findByField(String fieldName);
}
