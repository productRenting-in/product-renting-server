package com.product.renting.order.repository;

import com.product.renting.order.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, UUID> {

    boolean existsByProduct_ProductId(UUID productId);
}
