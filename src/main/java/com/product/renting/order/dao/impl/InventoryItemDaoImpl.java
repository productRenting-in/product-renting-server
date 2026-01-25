package com.product.renting.order.dao.impl;

import com.product.renting.common.exception.ResourceNotCreatedException;
import com.product.renting.common.exception.ResourceNotFoundException;
import com.product.renting.order.dao.InventoryItemDao;
import com.product.renting.order.entity.InventoryItem;
import com.product.renting.order.repository.InventoryItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Slf4j
@Repository
@RequiredArgsConstructor
public class InventoryItemDaoImpl implements InventoryItemDao {

    private final InventoryItemRepository inventoryItemRepository;

    @Override
    public InventoryItem create(InventoryItem inventoryItem) {
        try {
            log.debug("DAO - Creating inventory item");
            return inventoryItemRepository.save(inventoryItem);
        } catch (Exception ex) {
            log.error("DAO - Error while creating inventory item", ex);
            throw new ResourceNotCreatedException("DAO - Error while creating inventory item", ex);
        }
    }

    @Override
    public boolean existsByProductId(UUID productId) {
        return inventoryItemRepository.existsByProduct_ProductId(productId);
    }

    @Override
    public InventoryItem getByIdOrThrow(UUID inventoryItemId) {
        log.debug("DAO - Fetching inventory item by id {}", inventoryItemId);
        return inventoryItemRepository.findById(inventoryItemId)
                .orElseThrow(() -> {
                    log.warn("DAO - Inventory item not found for id {}", inventoryItemId);
                    return new ResourceNotFoundException("Inventory item not found with id: " + inventoryItemId);
                });
    }

    @Override
    public InventoryItem update(InventoryItem existing) {
        try {
            log.debug("DAO - Updating inventory item");
            return inventoryItemRepository.save(existing);
        } catch (Exception ex) {
            log.error("DAO - Error while updating inventory item", ex);
            throw new ResourceNotCreatedException("DAO - Error while updating inventory item", ex);
        }
    }
}
