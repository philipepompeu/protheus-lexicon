package com.philipepompeu.protheus_lexicon_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philipepompeu.protheus_lexicon_backend.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
    Optional<UserEntity> findByUsername(String userName);
}
