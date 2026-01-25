package com.product.renting.order.dao;

import com.product.renting.order.entity.InventoryItem;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

/**
 * Data Access Object interface for InventoryItem entity.
 * Defines operations for accessing and manipulating InventoryItem data.
 */
public interface InventoryItemDao {

    /**
     * Create a new inventory item
     *
     * @return the created inventory item
     */
    InventoryItem create(InventoryItem inventoryItem);

    boolean existsByProductId(UUID productId);

    InventoryItem getByIdOrThrow(@NotNull(message = "inventoryItemId is required") UUID inventoryItemId);

    /**
     * Update an existing inventory item
     *
     * @return the updated inventory item
     */
    InventoryItem update(InventoryItem existing);
}
