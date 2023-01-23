package com.coctails.repository;

import com.coctails.entity.ConfirmationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationTokenEntity, Integer> {
    Optional<ConfirmationTokenEntity> findByToken(String email);
}
