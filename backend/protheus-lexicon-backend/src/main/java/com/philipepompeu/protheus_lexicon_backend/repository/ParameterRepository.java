package com.philipepompeu.protheus_lexicon_backend.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.philipepompeu.protheus_lexicon_backend.domain.ParameterEntity;

public interface ParameterRepository extends JpaRepository<ParameterEntity, BigInteger>{

    Page<ParameterEntity> findAllByOrderByName(Pageable pageable);
    Page<ParameterEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Optional<ParameterEntity> findByName(String name);
    
}
