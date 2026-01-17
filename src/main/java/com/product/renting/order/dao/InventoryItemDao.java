package com.product.renting.order.dao;

import com.product.renting.order.entity.InventoryItem;

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
}
