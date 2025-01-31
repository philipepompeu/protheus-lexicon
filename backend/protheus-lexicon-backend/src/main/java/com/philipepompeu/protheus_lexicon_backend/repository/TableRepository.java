package com.philipepompeu.protheus_lexicon_backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<TableEntity, String>{

    Page<TableEntity> findAllByOrderById(Pageable pageable);
    Page<TableEntity> findByIdContainingIgnoreCase(String chave, Pageable pageable);
    
}
