package com.philipepompeu.protheus_lexicon_backend.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.philipepompeu.protheus_lexicon_backend.domain.TableEntity;

public interface TableRepository extends JpaRepository<TableEntity, String>{

    Page<TableEntity> findAllByOrderById(Pageable pageable);
    Page<TableEntity> findByIdContainingIgnoreCase(String chave, Pageable pageable);
    Optional<TableEntity> findById(String id);
    
}
