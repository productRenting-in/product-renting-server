package com.product.renting.order.service.impl;

import com.product.renting.common.exception.DuplicateResourceException;
import com.product.renting.common.exception.ValidationException;
import com.product.renting.order.dao.InventoryItemDao;
import com.product.renting.order.dao.ProductDao;
import com.product.renting.order.dto.request.CreateInventoryItemRequest;
import com.product.renting.order.dto.request.UpdateInventoryItemRequest;
import com.product.renting.order.dto.response.InventoryItemResponse;
import com.product.renting.order.entity.InventoryItem;
import com.product.renting.order.entity.Product;
import com.product.renting.order.enumeration.TrackingType;
import com.product.renting.order.mapper.InventoryItemMapper;
import com.product.renting.order.service.InventoryItemService;
import com.product.renting.order.service.SerialNumberGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryItemServiceImpl implements InventoryItemService {

    private final InventoryItemMapper inventoryItemMapper;
    private final ProductDao productDao;
    private final SerialNumberGeneratorService serialNumberGeneratorService;
    private final InventoryItemDao inventoryItemDao;

    @Override
    public InventoryItemResponse create(CreateInventoryItemRequest request) {
        UUID productId = request.getProductId();
        Product product = productDao.getByIdOrThrow(productId);
        validateRequest(product, request);
        InventoryItem inventoryItem = inventoryItemMapper.toCreateEntity(request);
        inventoryItem.setProduct(product);

        // Generate serial number for SERIALIZED items
        if (product.getTrackingType() == TrackingType.SERIALIZED) {
            inventoryItem.setSerialNumber(serialNumberGeneratorService.generateSerialNumber(product));
        }
        InventoryItem saved = inventoryItemDao.create(inventoryItem);
        return inventoryItemMapper.toResponse(saved);
    }

    private void validateRequest(Product product, CreateInventoryItemRequest request) {
        TrackingType trackingType = product.getTrackingType();
        BigInteger quantity = request.getQuantity();

        switch (trackingType) {
            case BULK -> {
                // BULK items require a quantity > 0
                if (quantity == null) {
                    log.error("Validation failed: quantity is required for BULK inventory items");
                    throw new ValidationException("Quantity is required for BULK inventory items");
                }
                validateDuplicateStockEntry(request, product.getProductId());
            }
            case SERIALIZED -> {
                // SERIALIZED items must have quantity == 1
                if (quantity == null) {
                    request.setQuantity(BigInteger.ONE);
                    log.debug("Quantity not provided for SERIALIZED item. Defaulting to 1.");
                } else if (quantity.compareTo(BigInteger.ONE) != 0) {
                    log.error("Validation failed: quantity must be 1 for SERIALIZED inventory items, provided={}", quantity);
                    throw new ValidationException("Quantity must be 1 for SERIALIZED inventory items");
                }
            }
            default -> {
                log.warn("Unknown tracking type: {}", trackingType);
            }
        }
    }

    private void validateDuplicateStockEntry(CreateInventoryItemRequest request, UUID productId) {
        if(inventoryItemDao.existsByProductId(productId)) {
            log.error("BULK inventory stock is already present for product with ID: {}", productId);
            throw new DuplicateResourceException("BULK inventory stock is already present for product with ID: " + productId);
        }
    }


    @Override
    public InventoryItemResponse update(UpdateInventoryItemRequest request) {
        return null;
    }
}
