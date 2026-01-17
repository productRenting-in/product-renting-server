package com.product.renting.order.dao.impl;

import com.product.renting.common.exception.ResourceNotCreatedException;
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
}
