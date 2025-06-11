package com.philipepompeu.protheus_lexicon_backend.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philipepompeu.protheus_lexicon_backend.domain.TriggerEntity;

@Repository
public interface TriggerRepository extends JpaRepository<TriggerEntity, BigInteger>{
    List<TriggerEntity> findByField_FieldOrderBySequence(String field);
}
