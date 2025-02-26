package com.philipepompeu.protheus_lexicon_backend.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philipepompeu.protheus_lexicon_backend.domain.IndexEntity;

@Repository
public interface IndexRepository extends JpaRepository<IndexEntity, BigInteger>{
    List<IndexEntity> findByTable_IdOrderBySequence(String tableId);
}
