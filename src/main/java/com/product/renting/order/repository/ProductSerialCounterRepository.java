package com.product.renting.order.repository;

import com.product.renting.order.entity.ProductSerialCounter;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductSerialCounterRepository extends JpaRepository<ProductSerialCounter, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE) // prevents race conditions
    @Query("SELECT p FROM ProductSerialCounter p WHERE p.productId = :productId")
    Optional<ProductSerialCounter> findByProductIdForUpdate(UUID productId);
}