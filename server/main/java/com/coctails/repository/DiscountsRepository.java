package com.coctails.repository;

import com.coctails.entity.ConfirmationTokenEntity;
import com.coctails.entity.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscountsRepository extends JpaRepository<Discounts, Integer> {
    Optional<Discounts> findByName(String nameOfDiscount);

    void deleteDiscountsById(Integer id);
}
